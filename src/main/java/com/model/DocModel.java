package com.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class DocModel implements Serializable {
    private String docNum;
    private String docDate;
    private String operType;
    private BigDecimal amountOut;
    private String inn_Pay;
    private String kpp_Pay;
    private String cName_Pay;
    private String docGuid;
    private String bs_Pay;
    private String bic_Pay;
    private String bs_Ks_Pay;
    private String inn_Rcp;
    private String kpp_Rcp;
    private String cName_Rcp;
    private String bs_Rcp;
    private String bic_Rcp;
    private String bs_Ks_Rcp;
    private String purpose;

    public DocModel(String docNum, String docDate,
                    String operType, BigDecimal amountOut,
                    String inn_Pay, String kpp_Pay,
                    String cName_PAY, String docGuid,
                    String bs_Pay, String bic_Pay,
                    String bs_Ks_Pay, String inn_Rcp,
                    String kpp_Rcp, String cName_Rcp,
                    String bs_Rcp, String bic_Rcp,
                    String bs_Ks_Rcp, String purpose) {
        this.docNum = docNum;
        this.docDate = docDate;
        this.operType = operType;
        this.amountOut = amountOut;
        this.inn_Pay = inn_Pay;
        this.kpp_Pay = kpp_Pay;
        this.cName_Pay = cName_PAY;
        this.docGuid = docGuid;
        this.bs_Pay = bs_Pay;
        this.bic_Pay = bic_Pay;
        this.bs_Ks_Pay = bs_Ks_Pay;
        this.inn_Rcp = inn_Rcp;
        this.kpp_Rcp = kpp_Rcp;
        this.cName_Rcp = cName_Rcp;
        this.bs_Rcp = bs_Rcp;
        this.bic_Rcp = bic_Rcp;
        this.bs_Ks_Rcp = bs_Ks_Rcp;
        this.purpose = purpose;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public BigDecimal getAmountOut() {
        return amountOut;
    }

    public void setAmountOut(BigDecimal amountOut) {
        this.amountOut = amountOut;
    }

    public String getInn_Pay() {
        return inn_Pay;
    }

    public void setInn_Pay(String inn_Pay) {
        this.inn_Pay = inn_Pay;
    }

    public String getKpp_Pay() {
        return kpp_Pay;
    }

    public void setKpp_Pay(String kpp_Pay) {
        this.kpp_Pay = kpp_Pay;
    }

    public String getcName_PAY() {
        return cName_Pay;
    }

    public void setcName_PAY(String cName_PAY) {
        this.cName_Pay = cName_PAY;
    }

    public String getDocGuid() {
        return docGuid;
    }

    public void setDocGuid(String docGuid) {
        this.docGuid = docGuid;
    }

    public String getBs_Pay() {
        return bs_Pay;
    }

    public void setBs_Pay(String bs_Pay) {
        this.bs_Pay = bs_Pay;
    }

    public String getBic_Pay() {
        return bic_Pay;
    }

    public void setBic_Pay(String bic_Pay) {
        this.bic_Pay = bic_Pay;
    }

    public String getBs_Ks_Pay() {
        return bs_Ks_Pay;
    }

    public void setBs_Ks_Pay(String bs_Ks_Pay) {
        this.bs_Ks_Pay = bs_Ks_Pay;
    }

    public String getInn_Rcp() {
        return inn_Rcp;
    }

    public void setInn_Rcp(String inn_Rcp) {
        this.inn_Rcp = inn_Rcp;
    }

    public String getKpp_Rcp() {
        return kpp_Rcp;
    }

    public void setKpp_Rcp(String kpp_Rcp) {
        this.kpp_Rcp = kpp_Rcp;
    }

    public String getcName_Rcp() {
        return cName_Rcp;
    }

    public void setcName_Rcp(String cName_Rcp) {
        this.cName_Rcp = cName_Rcp;
    }

    public String getBs_Rcp() {
        return bs_Rcp;
    }

    public void setBs_Rcp(String bs_Rcp) {
        this.bs_Rcp = bs_Rcp;
    }

    public String getBic_Rcp() {
        return bic_Rcp;
    }

    public void setBic_Rcp(String bic_Rcp) {
        this.bic_Rcp = bic_Rcp;
    }

    public String getBs_Ks_Rcp() {
        return bs_Ks_Rcp;
    }

    public void setBs_Ks_Rcp(String bs_Ks_Rcp) {
        this.bs_Ks_Rcp = bs_Ks_Rcp;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
