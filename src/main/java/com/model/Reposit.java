package com.model;

import com.w3c.Doc;
import com.InfPayDoc;
import com.SKPREPORTKS;

import java.util.ArrayList;
import java.util.List;

public class Reposit {
    public ArrayList<Doc> reportList;
    public ArrayList<Doc> infPayList;
    public List<SKPREPORTKS.Docs.Doc> docsSKPREPORTKS;
    public List<InfPayDoc.Docs.Doc> docsInfPayDoc;

    public ArrayList<Doc> getReportList() {
        return reportList;
    }

    public void setReportList(ArrayList<Doc> reportList) {
        this.reportList = reportList;
    }

    public ArrayList<Doc> getInfPayList() {
        return infPayList;
    }

    public void setInfPayList(ArrayList<Doc> infPayList) {
        this.infPayList = infPayList;
    }

    public List<SKPREPORTKS.Docs.Doc> getDocsSKPREPORTKS() {
        return docsSKPREPORTKS;
    }

    public void setDocsSKPREPORTKS(List<SKPREPORTKS.Docs.Doc> docsSKPREPORTKS) {
        this.docsSKPREPORTKS = docsSKPREPORTKS;
    }

    public List<InfPayDoc.Docs.Doc> getDocsInfPayDoc() {
        return docsInfPayDoc;
    }

    public void setDocsInfPayDoc(List<InfPayDoc.Docs.Doc> docsInfPayDoc) {
        this.docsInfPayDoc = docsInfPayDoc;
    }
}
