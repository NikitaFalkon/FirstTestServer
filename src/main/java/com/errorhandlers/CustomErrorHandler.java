package com.errorhandlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.List;

public class CustomErrorHandler implements ErrorHandler {
    private static final Logger log = LoggerFactory.getLogger(CustomErrorHandler.class);
    private final List<SAXException> errors;

    public CustomErrorHandler(List<SAXException> errors) {
        this.errors = errors;
    }

    public void add(SAXException saxException) {
        errors.add(saxException);
    }

    public List<SAXException> exceptions() {
        return errors;
    }

    @Override
    public void warning(SAXParseException exception) {
            log.warn("Parse Warning at line " + exception.getLineNumber() +
                    " column " + exception.getColumnNumber() + ": " +
                    exception.getMessage(), exception);
    }

    @Override
    public void error(SAXParseException exception) {
            log.warn("Parse Error at line " + exception.getLineNumber() +
                    " column " + exception.getColumnNumber() + ": " +
                    exception.getMessage(), exception);
            errors.add(exception);
    }

    @Override
    public void fatalError(SAXParseException exception) {
            log.warn("Parse Fatal Error at line " + exception.getLineNumber() +
                    " column " + exception.getColumnNumber() + ": " +
                    exception.getMessage(), exception);
    }
}
