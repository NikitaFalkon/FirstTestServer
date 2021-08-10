package com.service;

import com.model.DocModel;
import com.w3c.Doc;

import com.model.Reposit;
import com.InfPayDoc;
import com.SKPREPORTKS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {
    @Autowired
    XmlService xmlService;
    @Autowired
    ConvertService convertService;
    @Autowired
    W3cService w3cService;
    @Autowired
    JaxbService trueJaxbService;

    private void combineObjects(ArrayList<Doc> infPay, ArrayList<Doc> report, ArrayList<DocModel> finalObject) throws InstantiationException, IllegalAccessException {
        report.forEach(repDoc -> {
            infPay.stream().filter(infDoc -> repDoc.getDocGUID().equalsIgnoreCase(infDoc.getGUID())).
                    findFirst().ifPresent(infDoc -> {
                        finalObject.add(convertService.transferW3c(repDoc, infDoc));
                    });
        });
    }
  public ArrayList<DocModel> createReportJax (List<File> files) throws IllegalAccessException, InstantiationException {
      ArrayList<DocModel> finalObject = new ArrayList<>();
      Reposit reposit = xmlService.getReposit(files);
      combineFinalObjects(reposit.getDocsInfPayDoc(), reposit.getDocsSKPREPORTKS(), finalObject);

      return finalObject;
  }
    public ArrayList<DocModel> createReportW3c (List<File> files) throws IllegalAccessException, InstantiationException {
        ArrayList<DocModel> finalObject = new ArrayList<>();
        Reposit reposit = w3cService.parse(files);
        combineObjects(reposit.getInfPayList(), reposit.getReportList(), finalObject);

        return finalObject;
    }

    private void combineFinalObjects(List<InfPayDoc.Docs.Doc> infPay, List<SKPREPORTKS.Docs.Doc> report, ArrayList<DocModel> finalObject) throws InstantiationException, IllegalAccessException {
        report.forEach(repDoc -> {
            infPay.stream().filter(infDoc -> repDoc.getDocGUID().equalsIgnoreCase(infDoc.getGUID())).
                    findFirst().ifPresent(infDoc -> {
                finalObject.add(convertService.transferJaxb(repDoc, infDoc));
            });
        });
    }
}
