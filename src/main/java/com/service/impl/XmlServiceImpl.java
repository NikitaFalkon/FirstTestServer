package com.service.impl;

import com.errorhandlers.CustomeErrorHandler;
import com.model.FileInfo;
import com.model.Reposit;
import com.service.JaxbService;
import com.service.XmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.*;

@Service
public class XmlServiceImpl implements XmlService {
    @Autowired
    JaxbService jaxbService;

    @Override
    public Reposit getReposit(Map<String, FileInfo> files) {
        Reposit reposit = new Reposit();
        Set<Object> set = new HashSet<>();

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
        if(file.contains("SKP_REPORT_KS") && !file.contains("Итоговая")) {
            return false;
        }

        return true;
    }

    @Override
    public boolean checkForInfPay(String file) {
        if(file.contains("Inf_Pay_Doc")) {
            return true;
        }

        return false;
    }

    @Override
    public String getValidationErrors(String name, String value, String xsdPath) throws IOException {
        List<SAXException> errors = validationErrors(value, file(xsdPath));

        if (!errors.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder( );

            for ( SAXException error : errors ) {
                errorMessage.append(error.toString()).append( "\r\n" );
            }

             return "Invalid " + name + " " + errorMessage.toString() + "\r\n";
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
    public boolean validation(String xsdPath, String xmlContent, List<SAXException> saxExceptions) {
        CustomeErrorHandler customeErrorHandler = new CustomeErrorHandler(saxExceptions);

        try {
            Validator validator = validator(file(xsdPath));
            validator.setErrorHandler(customeErrorHandler);
            validator.validate(new StreamSource(new StringReader(xmlContent)));
        } catch (SAXParseException e) {
            customeErrorHandler.add(e);
        } catch (SAXException e) {
            customeErrorHandler.add(e);
        } catch (IOException e) {
            return false;
        }

        return customeErrorHandler.exceptions().isEmpty();
    }

    @Override
    public List<SAXException> validationErrors(String xmlContent, String xsdPath) throws IOException {
        List<SAXException> errors = new ArrayList<>();
        CustomeErrorHandler customeErrorHandler = new CustomeErrorHandler(errors);

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
        Validator validator = schema.newValidator();

        return validator;
    }

    public String file(String name) {
        InputStream is = getClass().getClassLoader()
                .getResourceAsStream(name);

        return this.getClass().getResource("/PayDocs.xsd").getFile();
    }
}
