package com.service;

import com.model.Reposit;

import javax.xml.xpath.XPathExpressionException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public interface XmlService {
    Reposit getReposit(Map<String, String> files);
    boolean checkForTheFinal(String file) throws IOException;
    boolean checkForInfPay(String file) throws FileNotFoundException, XPathExpressionException;
}
