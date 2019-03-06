package com.webbapp.webapp.util.HttpRequest;

/**
 * @author Gustav
 * */
public interface HttpRequest {

    /**
     * Given a latitude and a longitude returns the name of the nearest city
     * @param lat Latitude in Decimal Degrees format
     * @param lng Longitude in Decimal Degrees format
     * @return The name of the nearest city
     * */
    String getCity(Double lat, Double lng);
}