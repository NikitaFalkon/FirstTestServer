package com.model;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Form {
    @NotNull()
    @Size(min=1, max=30)
    private  String name;
    @NotNull()
    private  MultipartFile zipFile;

    public Form() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setZipFile(MultipartFile multipartFile) {
        this.zipFile = multipartFile;
    }

    public String getName() {
        return name;
    }

    public MultipartFile getZipFile() {
        return zipFile;
    }

    public String toString() {
        return "Person(Name: " + this.name + ", File: " + this.zipFile + ")";
    }
}
