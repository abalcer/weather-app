package com.brainacademy.weather.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class JsonUtils {
    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
    }

    public static <T> T readValue(String json, Class<T> type) throws IOException {
        return objectMapper.readValue(json, type);
    }

    public static <T> T readValue(URL url, Class<T> type) throws IOException {
        return objectMapper.readValue(url, type);
    }


}
