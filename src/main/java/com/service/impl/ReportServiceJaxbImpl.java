package com.service.impl;

import com.InfPayDoc;
import com.SKPREPORTKS;
import com.model.DocModel;
import com.model.FileInfo;
import com.model.Reposit;
import com.service.*;
import com.w3c.Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("jx")
public class ReportServiceJaxbImpl implements ReportService {
    @Autowired
    XmlService xmlService;
    @Autowired
    ConvertService convertService;
    @Autowired
    JaxbService trueJaxbService;

    @Override
    public void combineObjects(List<Doc> infPay, List<Doc> report, List<DocModel> finalObject) {
        report.forEach(repDoc -> {
            infPay.stream().filter(infDoc -> repDoc.getDocGUID().equalsIgnoreCase(infDoc.getGUID())).
                    findFirst().ifPresent(infDoc -> {
                        finalObject.add(convertService.transferW3c(repDoc, infDoc));
                    });
        });
    }

    @Override
    public ArrayList<DocModel> createReport (Map<String, FileInfo> files) {
        ArrayList<DocModel> finalObject = new ArrayList<>();
        Reposit reposit = xmlService.getReposit(files);
        combineFinalObjects(reposit.getDocsInfPayDoc(), reposit.getDocsSKPREPORTKS(), finalObject);

        return finalObject;
    }

    @Override
    public void combineFinalObjects(List<InfPayDoc.Docs.Doc> infPay, List<SKPREPORTKS.Docs.Doc> report, List<DocModel> finalObject) {
        report.forEach(repDoc -> {
            infPay.stream().filter(infDoc -> repDoc.getDocGUID().equalsIgnoreCase(infDoc.getGUID())).
                    findFirst().ifPresent(infDoc -> {
                finalObject.add(convertService.transferJaxb(repDoc, infDoc));
            });
        });
    }
}
