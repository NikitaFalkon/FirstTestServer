package com.xsd;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class XsdClass {
    Map<String, String> map;

    public XsdClass() {
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
