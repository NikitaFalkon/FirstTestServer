//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.08.31 at 11:27:04 AM MSK 
//


package com;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DocNum" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="DocDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="DocDateOld" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="AccNum" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Report_type_flag" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Code_OKEU" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Docs"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Doc" maxOccurs="unbounded"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="Line_Num" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="DocNum" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="DocDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="DocGUID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="OperType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="Bic_Corr" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="AmountIn" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="AmountOut" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="SendAcc" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="RecipAcc" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="PurpPay" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Executor_SFP" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="Executor_Post" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="StmInfrmtn_TF"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="GUID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "docNum",
    "docDate",
    "docDateOld",
    "accNum",
    "reportTypeFlag",
    "codeOKEU",
    "docs",
    "executorSFP",
    "executorPost",
    "stmInfrmtnTF"
})
@XmlRootElement(name = "SKP_REPORT_KS")
public class SKPREPORTKS {

    @XmlElement(name = "DocNum", required = true)
    protected String docNum;
    @XmlElement(name = "DocDate", required = true)
    protected String docDate;
    @XmlElement(name = "DocDateOld", required = true)
    protected String docDateOld;
    @XmlElement(name = "AccNum", required = true)
    protected String accNum;
    @XmlElement(name = "Report_type_flag", required = true)
    protected String reportTypeFlag;
    @XmlElement(name = "Code_OKEU", required = true)
    protected String codeOKEU;
    @XmlElement(name = "Docs", required = true)
    protected SKPREPORTKS.Docs docs;
    @XmlElement(name = "Executor_SFP", required = true)
    protected String executorSFP;
    @XmlElement(name = "Executor_Post", required = true)
    protected String executorPost;
    @XmlElement(name = "StmInfrmtn_TF", required = true)
    protected SKPREPORTKS.StmInfrmtnTF stmInfrmtnTF;

    /**
     * Gets the value of the docNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocNum() {
        return docNum;
    }

    /**
     * Sets the value of the docNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocNum(String value) {
        this.docNum = value;
    }

    /**
     * Gets the value of the docDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocDate() {
        return docDate;
    }

    /**
     * Sets the value of the docDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocDate(String value) {
        this.docDate = value;
    }

    /**
     * Gets the value of the docDateOld property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocDateOld() {
        return docDateOld;
    }

    /**
     * Sets the value of the docDateOld property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocDateOld(String value) {
        this.docDateOld = value;
    }

    /**
     * Gets the value of the accNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccNum() {
        return accNum;
    }

    /**
     * Sets the value of the accNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccNum(String value) {
        this.accNum = value;
    }

    /**
     * Gets the value of the reportTypeFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportTypeFlag() {
        return reportTypeFlag;
    }

    /**
     * Sets the value of the reportTypeFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportTypeFlag(String value) {
        this.reportTypeFlag = value;
    }

    /**
     * Gets the value of the codeOKEU property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeOKEU() {
        return codeOKEU;
    }

    /**
     * Sets the value of the codeOKEU property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeOKEU(String value) {
        this.codeOKEU = value;
    }

    /**
     * Gets the value of the docs property.
     * 
     * @return
     *     possible object is
     *     {@link SKPREPORTKS.Docs }
     *     
     */
    public SKPREPORTKS.Docs getDocs() {
        return docs;
    }

    /**
     * Sets the value of the docs property.
     * 
     * @param value
     *     allowed object is
     *     {@link SKPREPORTKS.Docs }
     *     
     */
    public void setDocs(SKPREPORTKS.Docs value) {
        this.docs = value;
    }

    /**
     * Gets the value of the executorSFP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecutorSFP() {
        return executorSFP;
    }

    /**
     * Sets the value of the executorSFP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecutorSFP(String value) {
        this.executorSFP = value;
    }

    /**
     * Gets the value of the executorPost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecutorPost() {
        return executorPost;
    }

    /**
     * Sets the value of the executorPost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecutorPost(String value) {
        this.executorPost = value;
    }

    /**
     * Gets the value of the stmInfrmtnTF property.
     * 
     * @return
     *     possible object is
     *     {@link SKPREPORTKS.StmInfrmtnTF }
     *     
     */
    public SKPREPORTKS.StmInfrmtnTF getStmInfrmtnTF() {
        return stmInfrmtnTF;
    }

    /**
     * Sets the value of the stmInfrmtnTF property.
     * 
     * @param value
     *     allowed object is
     *     {@link SKPREPORTKS.StmInfrmtnTF }
     *     
     */
    public void setStmInfrmtnTF(SKPREPORTKS.StmInfrmtnTF value) {
        this.stmInfrmtnTF = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Doc" maxOccurs="unbounded"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="Line_Num" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="DocNum" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="DocDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="DocGUID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="OperType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="Bic_Corr" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="AmountIn" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="AmountOut" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="SendAcc" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="RecipAcc" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="PurpPay" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "doc"
    })
    public static class Docs {

        @XmlElement(name = "Doc", required = true)
        protected List<SKPREPORTKS.Docs.Doc> doc;

        /**
         * Gets the value of the doc property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the doc property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDoc().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SKPREPORTKS.Docs.Doc }
         * 
         * 
         */
        public List<SKPREPORTKS.Docs.Doc> getDoc() {
            if (doc == null) {
                doc = new ArrayList<SKPREPORTKS.Docs.Doc>();
            }
            return this.doc;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="Line_Num" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="DocNum" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="DocDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="DocGUID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="OperType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="Bic_Corr" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="AmountIn" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="AmountOut" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="SendAcc" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="RecipAcc" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="PurpPay" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "lineNum",
            "docNum",
            "docDate",
            "docGUID",
            "operType",
            "bicCorr",
            "amountIn",
            "amountOut",
            "sendAcc",
            "recipAcc",
            "purpPay"
        })
        public static class Doc {

            @XmlElement(name = "Line_Num", required = true)
            protected String lineNum;
            @XmlElement(name = "DocNum", required = true)
            protected String docNum;
            @XmlElement(name = "DocDate", required = true)
            protected String docDate;
            @XmlElement(name = "DocGUID", required = true)
            protected String docGUID;
            @XmlElement(name = "OperType", required = true)
            protected String operType;
            @XmlElement(name = "Bic_Corr", required = true)
            protected String bicCorr;
            @XmlElement(name = "AmountIn", required = true)
            protected String amountIn;
            @XmlElement(name = "AmountOut", required = true)
            protected String amountOut;
            @XmlElement(name = "SendAcc", required = true)
            protected String sendAcc;
            @XmlElement(name = "RecipAcc", required = true)
            protected String recipAcc;
            @XmlElement(name = "PurpPay", required = true)
            protected String purpPay;

            /**
             * Gets the value of the lineNum property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLineNum() {
                return lineNum;
            }

            /**
             * Sets the value of the lineNum property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLineNum(String value) {
                this.lineNum = value;
            }

            /**
             * Gets the value of the docNum property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDocNum() {
                return docNum;
            }

            /**
             * Sets the value of the docNum property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDocNum(String value) {
                this.docNum = value;
            }

            /**
             * Gets the value of the docDate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDocDate() {
                return docDate;
            }

            /**
             * Sets the value of the docDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDocDate(String value) {
                this.docDate = value;
            }

            /**
             * Gets the value of the docGUID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDocGUID() {
                return docGUID;
            }

            /**
             * Sets the value of the docGUID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDocGUID(String value) {
                this.docGUID = value;
            }

            /**
             * Gets the value of the operType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getOperType() {
                return operType;
            }

            /**
             * Sets the value of the operType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setOperType(String value) {
                this.operType = value;
            }

            /**
             * Gets the value of the bicCorr property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getBicCorr() {
                return bicCorr;
            }

            /**
             * Sets the value of the bicCorr property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setBicCorr(String value) {
                this.bicCorr = value;
            }

            /**
             * Gets the value of the amountIn property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAmountIn() {
                return amountIn;
            }

            /**
             * Sets the value of the amountIn property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAmountIn(String value) {
                this.amountIn = value;
            }

            /**
             * Gets the value of the amountOut property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAmountOut() {
                return amountOut;
            }

            /**
             * Sets the value of the amountOut property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAmountOut(String value) {
                this.amountOut = value;
            }

            /**
             * Gets the value of the sendAcc property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSendAcc() {
                return sendAcc;
            }

            /**
             * Sets the value of the sendAcc property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSendAcc(String value) {
                this.sendAcc = value;
            }

            /**
             * Gets the value of the recipAcc property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getRecipAcc() {
                return recipAcc;
            }

            /**
             * Sets the value of the recipAcc property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setRecipAcc(String value) {
                this.recipAcc = value;
            }

            /**
             * Gets the value of the purpPay property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPurpPay() {
                return purpPay;
            }

            /**
             * Sets the value of the purpPay property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPurpPay(String value) {
                this.purpPay = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="GUID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "guid"
    })
    public static class StmInfrmtnTF {

        @XmlElement(name = "GUID", required = true)
        protected String guid;

        /**
         * Gets the value of the guid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGUID() {
            return guid;
        }

        /**
         * Sets the value of the guid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGUID(String value) {
            this.guid = value;
        }

    }

}
