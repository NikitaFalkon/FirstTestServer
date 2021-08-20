package com.service.impl;

import com.model.Reposit;
import com.service.JaxbService;
import com.service.XmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import javax.xml.xpath.XPathExpressionException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class XmlServiceImpl implements XmlService {
    @Autowired
    JaxbService jaxbService;

    @Override
    public Reposit getReposit(Map<String, String> files) {
        Reposit reposit = new Reposit();
        Set<Object> set = new HashSet<>();

        for(Map.Entry<String, String> entry : files.entrySet()) {
            try  {
                if (checkForTheFinal(entry.getValue())) {
                    if (checkForInfPay(entry.getValue())) {
                        reposit.setDocsInfPayDoc(jaxbService.getInfPayDoc(entry.getValue()));
                    } else {
                        reposit.setDocsSKPREPORTKS(jaxbService.getReportKS(entry.getValue()));
                    }
                } else {
                    break;
                }
            }  catch (JAXBException | IOException | XPathExpressionException e) {
                e.printStackTrace();
            }
        }

        return  reposit;
    }

    @Override
    public boolean checkForTheFinal(String file) throws IOException {
        if(file.contains("SKP_REPORT_KS") && !file.contains("Итоговая")) {
            return false;
        }

        return true;
    }

    @Override
    public boolean checkForInfPay(String file) throws FileNotFoundException, XPathExpressionException {
        if(file.contains("Inf_Pay_Doc")) {
            return true;
        }

        return false;
    }
}
