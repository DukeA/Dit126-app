package com.webbapp.webapp.util;

import com.webbapp.webapp.util.HttpRequest.HttpRequest;
import com.webbapp.webapp.util.HttpRequest.HttpRequestFactory;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UrlConnectionTest {

    @Test
    @DisplayName("Testing request")
    public void requestTest(){
        HttpRequest req = HttpRequestFactory.getHttpRequest();
        String city = req.getCity(57.709197, 11.973265);
        assertEquals("Gothenburg", city);
    }
}
