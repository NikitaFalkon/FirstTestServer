package com.service.impl;

import com.model.Reposit;
import com.service.RepositW3c;
import com.w3c.Doc;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

@Service("SKP_REPORT_KS")
public class RepositReportImpl implements RepositW3c {
    @Override
    public Reposit createList(NodeList docs, Reposit reposit) {
        List<Doc> docList = new ArrayList<>();

        for (int i = 0; i < docs.getLength(); i++) {
            Node node = docs.item(i);
            Doc doc1 = new Doc();
            Element element = (Element) node;
            doc1.setDocNum(getNodeValue(element, "DocNum"));
            doc1.setDocDate(getNodeValue(element, "DocDate"));
            doc1.setDocGUID(getNodeValue(element, "DocGUID"));
            doc1.setOperType(getNodeValue(element, "OperType"));
            doc1.setAmountOut(getNodeValue(element, "AmountOut"));
            docList.add(doc1);
        }

        reposit.setReportList(docList);

        return reposit;
    }
}
