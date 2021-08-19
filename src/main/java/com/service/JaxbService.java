package com.service;

import com.InfPayDoc;
import com.SKPREPORTKS;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;

public interface JaxbService {
    List<InfPayDoc.Docs.Doc> getInfPayDoc(String file) throws FileNotFoundException, JAXBException;
    List<SKPREPORTKS.Docs.Doc> getReportKS(String file) throws FileNotFoundException, JAXBException;
}
