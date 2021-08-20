package com.service;

import com.model.Reposit;

import java.util.Map;

public interface W3cService {
    Reposit parse(Map<String, String> files);
}
