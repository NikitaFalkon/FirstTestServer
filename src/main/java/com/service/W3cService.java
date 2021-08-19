package com.service;

import com.model.Reposit;
import com.w3c.Doc;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.List;
import java.util.Map;

public interface W3cService {
    Reposit parse(Map<String, String> files);
    List<Doc> infPayDoc (NodeList docs);
    String getNodeValue(Element root, String name);
    Element getNode(Element root, String name);
    List<Doc> reportKsDoc(NodeList docs);
}
