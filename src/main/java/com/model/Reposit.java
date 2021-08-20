package com.model;

import com.w3c.Doc;
import com.InfPayDoc;
import com.SKPREPORTKS;

import java.util.List;

public class Reposit {
    private List<Doc> reportList;
    private List<Doc> infPayList;
    private List<SKPREPORTKS.Docs.Doc> docsSKPREPORTKS;
    private List<InfPayDoc.Docs.Doc> docsInfPayDoc;

    public List<Doc> getReportList() {
        return reportList;
    }

    public void setReportList(List<Doc> reportList) {
        this.reportList = reportList;
    }

    public List<Doc> getInfPayList() {
        return infPayList;
    }

    public void setInfPayList(List<Doc> infPayList) {
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
