package com.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

@Service
public class XsdClass {
    HashMap<String, Object> yamlClass = null;

    public XsdClass() throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        File file = new File("src/main/resources/FilePath.yaml");
        TypeReference<HashMap<String,Object>> typeRef
                = new TypeReference<HashMap<String,Object>>() {};
        yamlClass = mapper.readValue(file, typeRef);
    }

    public String xsd(String xsd) {
        String s = yamlClass.get(xsd).toString();
        return yamlClass.get(xsd).toString();
    }
}
