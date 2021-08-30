package com.xsd;

import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class XsdClass {
    Map<String, String> map = null;

    public XsdClass() throws IOException {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("FilePath.yaml");
        map = yaml.load(inputStream);
    }

    public String xsd(String xsd) {
        String s = map.get(xsd);
        return map.get(xsd);
    }
}
