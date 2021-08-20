package com.service.impl;

import com.InfPayDoc;
import com.SKPREPORTKS;
import com.model.DocModel;
import com.model.Reposit;
import com.service.*;
import com.w3c.Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("wc")
public class ReportServiceW3cImpl implements ReportService {
    @Autowired
    XmlService xmlService;
    @Autowired
    ConvertService convertService;
    @Autowired
    W3cService w3cService;

    @Override
    public ArrayList<DocModel> createReport(Map<String, String> files) {
        ArrayList<DocModel> finalObject = new ArrayList<>();
        Reposit reposit = w3cService.parse(files);
        combineObjects(reposit.getInfPayList(), reposit.getReportList(), finalObject);

        return finalObject;
    }



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
    public void combineFinalObjects(List<InfPayDoc.Docs.Doc> infPay, List<SKPREPORTKS.Docs.Doc> report, List<DocModel> finalObject) {
        report.forEach(repDoc -> {
            infPay.stream().filter(infDoc -> repDoc.getDocGUID().equalsIgnoreCase(infDoc.getGUID())).
                    findFirst().ifPresent(infDoc -> {
                finalObject.add(convertService.transferJaxb(repDoc, infDoc));
            });
        });
    }
}
