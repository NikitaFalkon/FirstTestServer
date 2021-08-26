package com.service.impl;

import com.model.CustomeErrorHandler;
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
    public boolean checkForTheFinal(String file) throws IOException {
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
    public String validation(String name, String value, String xsdPath) {
        List<SAXException> errors = new ArrayList<>();
        SchemaFactory factory = null;
        Schema schema = null;
        CustomeErrorHandler customeErrorHandler = null;

        try {
            factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            schema = factory.newSchema(new File(xsdPath));
        } catch (SAXException e) {
            return e.toString();
        }

        try {
            Validator validator = schema.newValidator();
            customeErrorHandler = new CustomeErrorHandler(errors);
            validator.setErrorHandler(new CustomeErrorHandler(errors));
            validator.validate(new StreamSource(new StringReader(value)));

            if ( customeErrorHandler.exceptions().size() != 0 ) {
                StringBuilder errorMessage = new StringBuilder( );

                for ( SAXException error : errors ) {
                    errorMessage.append(error.toString()).append( "\r\n" );
                }

                return "Invalid " + name + " " + errorMessage.toString() + "\r\n";
            }
        } catch (SAXParseException e) {
            customeErrorHandler.add(e);
        } catch (IOException e) {
            return "Unable to validate" + name + "\n";
        } catch (SAXException e) {
            customeErrorHandler.add(e);
        }

        return name + "is valid";
    }
}
