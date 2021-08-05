package com.service;

import com.InfPayDoc;
import com.SKPREPORTKS;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class JaxbService {
    public List<InfPayDoc.Docs.Doc> getInfPayDoc(File file) throws FileNotFoundException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(InfPayDoc.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        InfPayDoc infPayDoc = (InfPayDoc) unmarshaller.unmarshal(new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8));

        return infPayDoc.getDocs().getDoc();
    }
    public List<SKPREPORTKS.Docs.Doc> getReportKS(File file) throws FileNotFoundException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(SKPREPORTKS.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        SKPREPORTKS reportKS = (SKPREPORTKS) unmarshaller.unmarshal(new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8));

        return reportKS.getDocs().getDoc();
    }
}
