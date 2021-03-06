package com.service.impl;

import com.model.NodeClass;
import com.model.Reposit;
import com.service.RepositW3c;
import com.w3c.BankPay;
import com.w3c.Doc;
import com.w3c.InfPay;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

@Service("Inf_Pay_Doc")
public class RepositInfPayImpl implements RepositW3c {
    @Override
    public Reposit createList (NodeList docs, Reposit reposit) {
        List<Doc> docList = new ArrayList<>();

        for (int i = 0; i < docs.getLength(); i++) {
            Node node = docs.item(i);
            Doc doc1 = new Doc();
            Element element = (Element) node;
            Element infPay1 = NodeClass.getNode(element, "Inf_PAY");
            InfPay infPay2 = new InfPay();
            infPay2.setINN_PAY(NodeClass.getNodeValue(infPay1, "INN_PAY"));
            infPay2.setKPP_PAY(NodeClass.getNodeValue(infPay1, "KPP_PAY"));
            infPay2.setCName_PAY(NodeClass.getNodeValue(infPay1, "CName_PAY"));
            doc1.setInfPay(infPay2);
            Element bankPayElement = NodeClass.getNode(element, "Bank_PAY");
            BankPay bankPay1 = new BankPay();
            bankPay1.setBS_PAY(NodeClass.getNodeValue(bankPayElement, "BS_PAY"));
            bankPay1.setBIC_PAY(NodeClass.getNodeValue(bankPayElement, "BIC_PAY"));
            bankPay1.setBS_KS_PAY(NodeClass.getNodeValue(bankPayElement, "BS_KS_PAY"));
            doc1.setBankPay(bankPay1);
            InfPay infRcp = new InfPay();
            Element infRcpElement = NodeClass.getNode(element, "Inf_RCP");
            infRcp.setINN_PAY(NodeClass.getNodeValue(infRcpElement, "INN_PAY"));
            infRcp.setKPP_PAY(NodeClass.getNodeValue(infRcpElement, "KPP_PAY"));
            infRcp.setCName_PAY(NodeClass.getNodeValue(infRcpElement, "CName_PAY"));
            doc1.setInfRcp(infRcp);
            Element bankRcpElement = NodeClass.getNode(element,"Bank_RCP");
            BankPay bankRcp = new BankPay();
            bankRcp.setBS_PAY(NodeClass.getNodeValue(bankRcpElement, "BS_PAY"));
            bankRcp.setBIC_PAY(NodeClass.getNodeValue(bankRcpElement, "BIC_PAY"));
            bankRcp.setBS_KS_PAY(NodeClass.getNodeValue(bankRcpElement, "BS_KS_PAY"));
            doc1.setBankRcp(bankRcp);
            doc1.setGUID(NodeClass.getNodeValue(element, "GUID"));
            doc1.setPurpose(NodeClass.getNodeValue(element, "Purpose"));
            docList.add(doc1);
        }

        reposit.setInfPayList(docList);

        return reposit;
    }
}
