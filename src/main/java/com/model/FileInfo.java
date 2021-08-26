package com.model;

public class FileInfo {
    private String rootElement;
    private String textContent;

    public FileInfo(String rootElement, String textContent) {
        this.rootElement = rootElement;
        this.textContent = textContent;
    }

    public String getRootElement() {
        return rootElement;
    }

    public void setRootElement(String rootElement) {
        this.rootElement = rootElement;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}
