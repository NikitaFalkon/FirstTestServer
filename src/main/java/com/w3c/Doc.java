package com.w3c;

public class Doc {
    private String DocNum;
    private String DocDate;
    private String DocGUID;
    private String OperType;
    private String AmountOut;
    private String GUID;
    private InfPay InfPay;
    private BankPay bankPay;
    private InfPay infRcp;
    private BankPay bankRcp;
    private String purpose;

    public Doc(String docNum, String docDate, String docGUID, String operType) {
        this.DocNum = docNum;
        this.DocDate = docDate;
        this.DocGUID = docGUID;
        this.OperType = operType;
    }

    public Doc(String docNum, String docDate, String docGUID, String operType, String amountOut, String GUID, com.w3c.InfPay infPay, BankPay bankPay, InfPay infRcp, BankPay bankRcp, String purpose) {
        DocNum = docNum;
        DocDate = docDate;
        DocGUID = docGUID;
        OperType = operType;
        AmountOut = amountOut;
        this.GUID = GUID;
        InfPay = infPay;
        this.bankPay = bankPay;
        this.infRcp = infRcp;
        this.bankRcp = bankRcp;
        this.purpose = purpose;
    }

    public Doc(){}

    public String getGUID() {
        return GUID;
    }

    public void setGUID(String GUID) {
        this.GUID = GUID;
    }

    public com.w3c.InfPay getInfPay() {
        return InfPay;
    }

    public void setInfPay(com.w3c.InfPay infPay) {
        InfPay = infPay;
    }

    public BankPay getBankPay() {
        return bankPay;
    }

    public void setBankPay(BankPay bankPay) {
        this.bankPay = bankPay;
    }


    public String getDocNum() {
        return DocNum;
    }

    public void setDocNum(String docNum) {
        DocNum = docNum;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getDocGUID() {
        return DocGUID;
    }

    public void setDocGUID(String docGUID) {
        DocGUID = docGUID;
    }

    public String getOperType() {
        return OperType;
    }

    public void setOperType(String operType) {
        OperType = operType;
    }

    public String getDocDate() {
        return DocDate;
    }

    public void setDocDate(String docDate) {
        DocDate = docDate;
    }

    public String getAmountOut() {
        return AmountOut;
    }

    public void setAmountOut(String amountOut) {
        AmountOut = amountOut;
    }

    public com.w3c.InfPay getInfRcp() {
        return infRcp;
    }

    public void setInfRcp(com.w3c.InfPay infRcp) {
        this.infRcp = infRcp;
    }

    public BankPay getBankRcp() {
        return bankRcp;
    }

    public void setBankRcp(BankPay bankRcp) {
        this.bankRcp = bankRcp;
    }
}
