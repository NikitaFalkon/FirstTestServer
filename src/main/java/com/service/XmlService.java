package com.service;

import com.model.FileInfo;
import com.model.Reposit;
import org.xml.sax.SAXException;

import javax.xml.validation.Validator;
import javax.xml.xpath.XPathExpressionException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface XmlService {
    Reposit getReposit(Map<String, FileInfo> files);

    boolean checkForTheFinal(String file) throws IOException;

    boolean checkForInfPay(String file) throws FileNotFoundException, XPathExpressionException;

    public String getValidationErrors(String name, String value, String xsdPath) throws IOException;

    public boolean validation(String xsdPath, String xmlContent);

    public boolean validation(String xsdPath, String xmlContent, List<SAXException> saxExceptions);

    public List<SAXException> validationErrors(String xmlContent, String xsdPath) throws IOException;

    public Validator validator(String xsdPath) throws SAXException;
}
