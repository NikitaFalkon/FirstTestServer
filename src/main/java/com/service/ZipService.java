package com.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class ZipService {
    private List<File> getFiles(MultipartFile zip, BindingResult bindingResult) throws IOException {
        List<File> files = new ArrayList<>();
        ZipInputStream zin = new ZipInputStream(new BufferedInputStream(zip.getInputStream()));
        ZipEntry entry = null;

        while((entry = zin.getNextEntry()) != null) {
             File file = new File(entry.getName());
             FileOutputStream  os = new FileOutputStream(file);
             for (int c = zin.read(); c != -1; c = zin.read()) {
                 os.write(c);
             }
             os.close();
             files.add(file);
        }

        if (files.size()==0) {
            bindingResult.addError(new FieldError("form", "zipFile", "Wrong file"));
        }

        return files;
    }

    public List<File> convert(MultipartFile s, BindingResult bindingResult) throws IOException, TypeOfFileException {
        return getFiles(s, bindingResult);
    }

    public class TypeOfFileException extends Exception{
        public TypeOfFileException(String message){
            super(message);
        }
    }
}
