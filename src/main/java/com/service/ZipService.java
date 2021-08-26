package com.service;

import com.model.FileInfo;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;

public interface ZipService {
    Map<String, FileInfo> getFiles(MultipartFile zip, BindingResult bindingResult) throws IOException, ParserConfigurationException, SAXException;
    Map<String, FileInfo> convert(MultipartFile s, BindingResult bindingResult) throws IOException, ParserConfigurationException, SAXException;
}
