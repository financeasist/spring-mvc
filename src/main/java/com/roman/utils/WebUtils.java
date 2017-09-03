package com.roman.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class WebUtils {

    public static Map<String, String> getRequestHeadersInfo(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            map.put(key, value);
        }
        return map;
    }

    public static Map<String, String> getResponseHeadersInfo(HttpServletResponse response) {

        Map<String, String> map = new HashMap<>();

        Collection<String> headerNames = response.getHeaderNames();
        for (String headerName : headerNames) {
            String value = response.getHeader(headerName);
            map.put(headerName, value);
        }
        return map;
    }

    public static String getAccept(HttpServletRequest request) {
        return request.getHeader("accept");
    }
}
