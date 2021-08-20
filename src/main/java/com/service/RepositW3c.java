package com.service;

import com.model.Reposit;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public interface RepositW3c {
     Reposit createList (NodeList docs, Reposit reposit);

     default String getNodeValue(Element root, String name) {
          Element element = getNode(root, name);

          return element != null ? element.getTextContent() : null;
     }

     default Element getNode(Element root, String name) {
          if (root == null || name == null) {
               return null;
          }

          NodeList nodeList = root.getElementsByTagName(name);

          if (nodeList.getLength() != 0) {
               return (Element) nodeList.item(0);
          } else {
               return null;
          }
     }
}
