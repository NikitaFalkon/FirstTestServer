package com.service.impl;

import com.model.Reposit;
import com.service.RepositW3c;
import com.service.W3cService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

@Service
public class W3cServiceImpl implements W3cService {

    @Autowired
    private Map<String, RepositW3c> repositW3cMap = new HashMap<>();

    public Reposit parse(Map<String, String> files) {
        Reposit reposit = new Reposit();

        for(Map.Entry<String, String> entry : files.entrySet()) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;

            try {
                builder = factory.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }

            Document document = null;

            try {
                document = builder.parse(new InputSource(new StringReader(entry.getValue())));

            } catch (SAXException | IOException e) {
                e.printStackTrace();
            }

            Element elementCollection = document.getDocumentElement();
            NodeList docs = document.getElementsByTagName("Doc");
            reposit = repositW3cMap.get(elementCollection.getTagName()).createList(docs, reposit);
        }

        return reposit;
    }
}
