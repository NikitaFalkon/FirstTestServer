package com.service;

import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface ZipService {
    Map<String, String> getFiles(MultipartFile zip, BindingResult bindingResult) throws IOException;
    Map<String, String> convert(MultipartFile s, BindingResult bindingResult) throws IOException;
}
