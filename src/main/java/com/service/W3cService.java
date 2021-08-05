package com.service;

import com.w3c.*;
import com.model.Reposit;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class W3cService {
    public Reposit parse(List<File> files) {
        Reposit reposit = new Reposit();

        files.forEach(file -> {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;

            try {
                builder = factory.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }

            Document document = null;

            try {
                document = builder.parse(file);
            } catch (SAXException | IOException e) {
                e.printStackTrace();
            }

            Element elementCollection = document.getDocumentElement();
            NodeList docs = document.getElementsByTagName("Doc");

            if(elementCollection.toString().equals("[Inf_Pay_Doc: null]")){
                reposit.setInfPayList((ArrayList<Doc>) infPayDoc(docs));
            }

            if(elementCollection.toString().equals("[SKP_REPORT_KS: null]")){
                reposit.setReportList((ArrayList<Doc>) reportKsDoc(docs));
            }
        });

        return reposit;
    }
    public List<Doc> infPayDoc (NodeList docs){
        List<Doc> docList = new ArrayList<>();

        for (int i = 0; i < docs.getLength(); i++) {
            Node node = docs.item(i);
            Doc doc1 = new Doc();
                Element element = (Element) node;
                Element infPay1 = getNode(element, "Inf_PAY");
                InfPay infPay2 = new InfPay();
                infPay2.setINN_PAY(getNodeValue(infPay1, "INN_PAY"));
                infPay2.setKPP_PAY(getNodeValue(infPay1, "KPP_PAY"));
                infPay2.setCName_PAY(getNodeValue(infPay1, "CName_PAY"));
                doc1.setInfPay(infPay2);
                Element bankPayElement = getNode(element, "Bank_PAY");
                BankPay bankPay1 = new BankPay();
                bankPay1.setBS_PAY(getNodeValue(bankPayElement, "BS_PAY"));
                bankPay1.setBIC_PAY(getNodeValue(bankPayElement, "BIC_PAY"));
                bankPay1.setBS_KS_PAY(getNodeValue(bankPayElement, "BS_KS_PAY"));
                doc1.setBankPay(bankPay1);
                InfPay infRcp = new InfPay();
                Element infRcpElement = getNode(element, "Inf_RCP");
                infRcp.setINN_PAY(getNodeValue(infRcpElement, "INN_PAY"));
                infRcp.setKPP_PAY(getNodeValue(infRcpElement, "KPP_PAY"));
                infRcp.setCName_PAY(getNodeValue(infRcpElement, "CName_PAY"));
                doc1.setInfRcp(infRcp);
                Element bankRcpElement = getNode(element,"Bank_RCP");
                BankPay bankRcp = new BankPay();
                bankRcp.setBS_PAY(getNodeValue(bankRcpElement, "BS_PAY"));
                bankRcp.setBIC_PAY(getNodeValue(bankRcpElement, "BIC_PAY"));
                bankRcp.setBS_KS_PAY(getNodeValue(bankRcpElement, "BS_KS_PAY"));
                doc1.setBankRcp(bankRcp);
                doc1.setGUID(getNodeValue(element, "GUID"));
                doc1.setPurpose(getNodeValue(element, "Purpose"));
                docList.add(doc1);
        }

        return docList;
    }

    public List<Doc> reportKsDoc(NodeList docs) {
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

        return docList;
    }

    private String getNodeValue(Element root, String name) {
        Element element = getNode(root, name);

        return element != null ? element.getTextContent() : null;
    }

    private Element getNode(Element root, String name) {
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
