package com.service.impl;

import com.errorhandlers.CustomErrorHandler;
import com.model.FileInfo;
import com.model.Reposit;
import com.service.JaxbService;
import com.service.XmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

@Service
public class XmlServiceImpl implements XmlService {
    @Autowired
    JaxbService jaxbService;

    @Override
    public Reposit getReposit(Map<String, FileInfo> files) {
        Reposit reposit = new Reposit();

        for(Map.Entry<String, FileInfo> entry : files.entrySet()) {
            try  {
                if (checkForTheFinal(entry.getValue().getTextContent())) {
                    if (checkForInfPay(entry.getValue().getTextContent())) {
                        reposit.setDocsInfPayDoc(jaxbService.getInfPayDoc(entry.getValue().getTextContent()));
                    } else {
                        reposit.setDocsSKPREPORTKS(jaxbService.getReportKS(entry.getValue().getTextContent()));
                    }
                } else {
                    break;
                }
            }  catch (JAXBException | IOException e) {
                e.printStackTrace();
            }
        }

        return  reposit;
    }

    @Override
    public boolean checkForTheFinal(String file) {
        return !file.contains("SKP_REPORT_KS") || file.contains("Итоговая");
    }

    @Override
    public boolean checkForInfPay(String file) {
        return file.contains("Inf_Pay_Doc");
    }

    @Override
    public String getValidationErrors(String name, String value, String xsdPath) throws IOException {
        List<SAXException> errors = validationErrors(value, file(xsdPath));

        if (!errors.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder( );

            for ( SAXException error : errors ) {
                errorMessage.append(error.toString()).append( "\r\n" );
            }

             return "Invalid " + name + " " + errorMessage.toString();
        }

        return name + "is valid";
    }

    @Override
    public boolean validation(String xsdPath, String xmlContent) {
        try {
            Validator validator = validator(file(xsdPath));
            validator.validate(new StreamSource(new StringReader(xmlContent)));
        } catch (SAXException | IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean validation(String xsdPath, String xmlContent, List<SAXException> saxExceptions) throws IOException {
        CustomErrorHandler customeErrorHandler = new CustomErrorHandler(saxExceptions);

        try {
            Validator validator = validator(file(xsdPath));
            validator.setErrorHandler(customeErrorHandler);
            validator.validate(new StreamSource(new StringReader(xmlContent)));
        } catch (SAXException e) {
            customeErrorHandler.add(e);
        }

        return customeErrorHandler.exceptions().isEmpty();
    }

    @Override
    public List<SAXException> validationErrors(String xmlContent, String xsdPath) throws IOException {
        List<SAXException> errors = new ArrayList<>();
        CustomErrorHandler customeErrorHandler = new CustomErrorHandler(errors);

        try {
            Validator validator = validator(file(xsdPath));
            validator.setErrorHandler(customeErrorHandler);
            validator.validate(new StreamSource(new StringReader(xmlContent)));
        } catch (SAXException e) {
            customeErrorHandler.add(e);
        }

        return customeErrorHandler.exceptions();
    }

    @Override
    public Validator validator(String xsdPath) throws SAXException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new File(file(xsdPath)));

        return schema.newValidator();
    }

    public String file(String name) {
        return this.getClass().getResource(name).getFile();
    }
}
