package com.service.impl;

import com.service.ZipService;
import org.codehaus.plexus.util.StringOutputStream;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class ZipServiceImpl implements ZipService {
    @Override
    public Map<String, String> getFiles(MultipartFile zip, BindingResult bindingResult) throws IOException {
        Map<String, String> files = new HashMap<>();
        ZipInputStream zin = new ZipInputStream(new BufferedInputStream(zip.getInputStream()));
        ZipEntry entry = null;

        while((entry = zin.getNextEntry()) != null) {
            String name = entry.getName();
            String file = "";
            StringOutputStream os = new StringOutputStream();
            StringBuilder s = new StringBuilder();
            byte[] buffer = new byte[1024];
            int read = 0;
                while ((read = zin.read(buffer, 0, 1024)) >= 0) {
                    s.append(new String(buffer, 0, read));
                }
            files.put(name, s.toString());
        }

        if (files.size()==0) {
            bindingResult.addError(new FieldError("form", "zipFile", "Wrong file"));
        }

        return files;
    }

    @Override
    public Map<String, String> convert(MultipartFile s, BindingResult bindingResult) throws IOException {
        return getFiles(s, bindingResult);
    }
}
