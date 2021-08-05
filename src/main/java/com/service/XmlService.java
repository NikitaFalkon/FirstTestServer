package com.service;

import com.model.Reposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBException;
import javax.xml.xpath.*;
import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class XmlService {
    @Autowired
    JaxbService jaxbService;
    @Autowired
    JaxbService trueJaxbService;

    public Reposit getReposit(List<File> files) {
        Reposit reposit = new Reposit();
        Set<Object> set = new HashSet<>();

        for (File file : files) {
            try {
                if (checkForTheFinal(file)) {
                    if (checkForInfPay(file)) {
                        reposit.setDocsInfPayDoc(trueJaxbService.getInfPayDoc(file));
                    } else {
                        reposit.setDocsSKPREPORTKS(trueJaxbService.getReportKS(file));
                    }
                } else {
                    break;
                }
            } catch (JAXBException | IOException | XPathExpressionException e) {
                e.printStackTrace();
            }
        }

        return  reposit;
    }

    public boolean checkForTheFinal(File file) throws IOException {
        try {
            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            InputSource doc = new InputSource(new InputStreamReader(new FileInputStream(file)));
            Double count = (Double) xpath.evaluate("count(//SKP_REPORT_KS)", doc, XPathConstants.NUMBER);
            XPathExpression xPathExpression = xpath.compile(
                    "/SKP_REPORT_KS[Report_type_flag='Итоговая']/DocNum/text()"
            );
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean checkForInfPay(File file) throws FileNotFoundException, XPathExpressionException {
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        InputSource doc = new InputSource(new InputStreamReader(new FileInputStream(file)));
        Double count=(Double) xpath.evaluate("count(//Inf_Pay_Doc)", doc, XPathConstants.NUMBER);

        if (count>0) {
            return true;
        }

        return false;
    }
}
