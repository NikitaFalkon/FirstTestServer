package com.service;

import com.InfPayDoc;
import com.SKPREPORTKS;
import com.model.DocModel;
import com.w3c.Doc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ReportService {
    ArrayList<DocModel> createReport (Map<String, String> files);
    void combineObjects(List<Doc> infPay, List<Doc> report, List<DocModel> finalObject);
    void combineFinalObjects(List<InfPayDoc.Docs.Doc> infPay, List<SKPREPORTKS.Docs.Doc> report, List<DocModel> finalObject);
}
