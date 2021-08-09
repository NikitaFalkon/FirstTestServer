package com.service;

import com.w3c.Doc;
import com.model.DocModel;
import com.InfPayDoc;
import com.SKPREPORTKS;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConvertService {
    public DocModel transferW3c(Doc docrep, Doc doc){
        DocModel docModel = new DocModel(
                docrep.getDocNum(),
                docrep.getDocDate(),
                docrep.getOperType(),
                new BigDecimal(docrep.getAmountOut()),
                docrep.getDocGUID(),
                doc.getInfPay().getINN_PAY(),
                doc.getInfPay().getKPP_PAY(),
                doc.getInfPay().getCName_PAY(),
                doc.getBankPay().getBS_PAY(),
                doc.getBankPay().getBIC_PAY(),
                doc.getBankPay().getBS_KS_PAY(),
                doc.getInfRcp().getINN_PAY(),
                doc.getInfRcp().getKPP_PAY(),
                doc.getInfRcp().getCName_PAY(),
                doc.getBankRcp().getBS_PAY(),
                doc.getBankRcp().getBIC_PAY(),
                doc.getBankRcp().getBS_KS_PAY(),
                doc.getPurpose()
        );

        return docModel;
    }

    public DocModel transferJaxb(SKPREPORTKS.Docs.Doc docrep, InfPayDoc.Docs.Doc doc) {
        DocModel docModel = new DocModel(
                docrep.getDocNum(),
                docrep.getDocDate(),
                docrep.getOperType(),
                new BigDecimal(docrep.getAmountOut()),
                docrep.getDocGUID(),
                doc.getInfPAY().getINNPAY(),
                doc.getInfPAY().getKPPPAY(),
                doc.getInfPAY().getCNamePAY(),
                doc.getBankPAY().getBSPAY(),
                doc.getBankPAY().getBICPAY(),
                doc.getBankPAY().getBSKSPAY(),
                doc.getInfRCP().getINNPAY(),
                doc.getInfRCP().getKPPPAY(),
                doc.getInfRCP().getCNamePAY(),
                doc.getBankRCP().getBSPAY(),
                doc.getBankRCP().getBICPAY(),
                doc.getBankRCP().getBSKSPAY(),
                doc.getPurpose()
        );

        return docModel;
    }
}
