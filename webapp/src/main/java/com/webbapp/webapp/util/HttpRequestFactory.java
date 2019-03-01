package com.webbapp.webapp.util;

public class HttpRequestFactory {

    /**
     * Creates a concrete implementation of HttpRequest
     * */
    public static HttpRequest getHttpRequest(){
        return new UrlConnectionHttpRequest();
    }
}
