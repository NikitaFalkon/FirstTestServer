package com.service;

import com.model.FileInfo;
import com.model.Reposit;

import javax.xml.parsers.ParserConfigurationException;
import java.util.Map;

public interface W3cService {
    Reposit parse(Map<String, FileInfo> files) throws ParserConfigurationException;
}
