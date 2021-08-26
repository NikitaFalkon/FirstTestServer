package com.service.impl;

import com.model.FileInfo;
import com.service.ZipService;
import org.codehaus.plexus.util.StringOutputStream;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class ZipServiceImpl implements ZipService {
    @Override
    public Map<String, FileInfo> getFiles(MultipartFile zip, BindingResult bindingResult) throws IOException, ParserConfigurationException, SAXException {
        Map<String, FileInfo> files = new HashMap<>();
        ZipInputStream zin = new ZipInputStream(new BufferedInputStream(zip.getInputStream()));
        ZipEntry entry = null;

        while((entry = zin.getNextEntry()) != null) {
            String name = entry.getName();
            StringBuilder s = new StringBuilder();
            byte[] buffer = new byte[1024];
            int read = 0;
                while ((read = zin.read(buffer, 0, 1024)) >= 0) {
                    s.append(new String(buffer, 0, read));
                }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(s.toString())));
            document.getDocumentElement ();
            files.put(name, new FileInfo(document.getDocumentElement().getTagName(), s.toString()));
        }

        if (files.size()==0) {
            bindingResult.addError(new FieldError("form", "zipFile", "Wrong file"));
        }

        return files;
    }

    @Override
    public Map<String, FileInfo> convert(MultipartFile s, BindingResult bindingResult) throws IOException, ParserConfigurationException, SAXException {
        return getFiles(s, bindingResult);
    }
}
