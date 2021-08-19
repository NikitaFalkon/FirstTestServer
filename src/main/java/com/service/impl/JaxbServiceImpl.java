package com.service.impl;

import com.InfPayDoc;
import com.SKPREPORTKS;
import com.service.JaxbService;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.util.List;

@Service
public class JaxbServiceImpl implements JaxbService {

    @Override
    public List<InfPayDoc.Docs.Doc> getInfPayDoc(String file) throws  JAXBException {
        JAXBContext context = JAXBContext.newInstance(InfPayDoc.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(file);
        InfPayDoc infPayDoc = (InfPayDoc) unmarshaller.unmarshal(reader);

        return infPayDoc.getDocs().getDoc();
    }

    @Override
    public List<SKPREPORTKS.Docs.Doc> getReportKS(String file) throws  JAXBException {
        JAXBContext context = JAXBContext.newInstance(SKPREPORTKS.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StringReader reader = new StringReader(file);
        SKPREPORTKS reportKS = (SKPREPORTKS) unmarshaller.unmarshal(reader);

        return reportKS.getDocs().getDoc();
    }
}
