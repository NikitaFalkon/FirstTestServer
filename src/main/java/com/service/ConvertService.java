package com.service;

import com.InfPayDoc;
import com.SKPREPORTKS;
import com.model.DocModel;
import com.w3c.Doc;

public interface ConvertService {
    DocModel transferW3c(Doc docrep, Doc doc);
    DocModel transferJaxb(SKPREPORTKS.Docs.Doc docrep, InfPayDoc.Docs.Doc doc);
}
