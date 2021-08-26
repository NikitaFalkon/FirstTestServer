package com.service;

import com.model.FileInfo;
import com.model.Reposit;
import org.xml.sax.SAXException;

import javax.xml.xpath.XPathExpressionException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface XmlService {
    Reposit getReposit(Map<String, FileInfo> files);

    boolean checkForTheFinal(String file) throws IOException;

    boolean checkForInfPay(String file) throws FileNotFoundException, XPathExpressionException;

    String validation(String xmlSource, String xsdPath, String xmlName) throws SAXException;
}
