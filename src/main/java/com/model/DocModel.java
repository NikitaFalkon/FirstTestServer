package com.model;

import java.io.Serializable;

public class DocModel implements Serializable {
    private String docNum;
    private String docDate;
    private String operType;
    private String amountOut;
    private String INN_PAY;
    private String KPP_PAY;
    private String cName_PAY;
    private String DocGUID;
    private String BS_PAY;
    private String BIC_PAY;
    private String BS_KS_PAY;
    private String INN_RCP;
    private String KPP_RCP;
    private String cName_RCP;
    private String BS_RCP;
    private String BIC_RCP;
    private String BS_KS_RCP;
    private String purpose;

    public DocModel(String docNum, String docDate,
                    String operType, String amountOut,
                    String DocGUID, String INN_PAY,
                    String KPP_PAY, String CName_PAY,
                    String BS_PAY, String BIC_PAY,
                    String BS_KS_PAY, String INN_RCP,
                    String KPP_RCP, String CName_RCP,
                    String BS_RCP, String BIC_RCP,
                    String BS_KS_RCP, String Purpose) {
        this.docNum = docNum;
        this.docDate = docDate;
        this.operType = operType;
        this.amountOut = amountOut;
        this.INN_PAY = INN_PAY;
        this.KPP_PAY = KPP_PAY;
        this.cName_PAY = CName_PAY;
        this.BS_PAY = BS_PAY;
        this.BIC_PAY = BIC_PAY;
        this.BS_KS_PAY = BS_KS_PAY;
        this.INN_RCP = INN_RCP;
        this.KPP_RCP = KPP_RCP;
        this.cName_RCP = CName_RCP;
        this.BS_RCP = BS_RCP;
        this.BIC_RCP = BIC_RCP;
        this.BS_KS_RCP = BS_KS_RCP;
        this.purpose = Purpose;
        this.DocGUID = DocGUID;
    }

    public DocModel() {}

    public String getINN_PAY() {
        return INN_PAY;
    }

    public void setINN_PAY(String INN_PAY) {
        this.INN_PAY = INN_PAY;
    }

    public String getKPP_PAY() {
        return KPP_PAY;
    }

    public void setKPP_PAY(String KPP_PAY) {
        this.KPP_PAY = KPP_PAY;
    }

    public String getDocGUID() {
        return DocGUID;
    }

    public void setDocGUID(String docGUID) {
        DocGUID = docGUID;
    }

    public String getBS_PAY() {
        return BS_PAY;
    }

    public void setBS_PAY(String BS_PAY) {
        this.BS_PAY = BS_PAY;
    }

    public String getBIC_PAY() {
        return BIC_PAY;
    }

    public void setBIC_PAY(String BIC_PAY) {
        this.BIC_PAY = BIC_PAY;
    }

    public String getBS_KS_PAY() {
        return BS_KS_PAY;
    }

    public void setBS_KS_PAY(String BS_KS_PAY) {
        this.BS_KS_PAY = BS_KS_PAY;
    }

    public String getINN_RCP() {
        return INN_RCP;
    }

    public void setINN_RCP(String INN_RCP) {
        this.INN_RCP = INN_RCP;
    }

    public String getKPP_RCP() {
        return KPP_RCP;
    }

    public void setKPP_RCP(String KPP_RCP) {
        this.KPP_RCP = KPP_RCP;
    }

    public String getBS_RCP() {
        return BS_RCP;
    }

    public void setBS_RCP(String BS_RCP) {
        this.BS_RCP = BS_RCP;
    }

    public String getBIC_RCP() {
        return BIC_RCP;
    }

    public void setBIC_RCP(String BIC_RCP) {
        this.BIC_RCP = BIC_RCP;
    }

    public String getBS_KS_RCP() {
        return BS_KS_RCP;
    }

    public void setBS_KS_RCP(String BS_KS_RCP) {
        this.BS_KS_RCP = BS_KS_RCP;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getcName_PAY() {
        return cName_PAY;
    }

    public void setcName_PAY(String cName_PAY) {
        this.cName_PAY = cName_PAY;
    }

    public String getcName_RCP() {
        return cName_RCP;
    }

    public void setcName_RCP(String cName_RCP) {
        this.cName_RCP = cName_RCP;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getAmountOut() {
        return amountOut;
    }

    public void setAmountOut(String amountOut) {
        this.amountOut = amountOut;
    }
}
