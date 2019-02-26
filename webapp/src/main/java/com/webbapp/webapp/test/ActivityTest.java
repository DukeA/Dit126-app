package com.webbapp.webapp.test;

import com.webbapp.webapp.model.Actvity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

/**
 * @Author: Adam Grandén
 * @Class: The class is an structure of the
 */
public class ActivityTest {

    @BeforeAll
    static  void init() {
        String title =  "Runner";
        String type = "Jogging";
        String description = "The best runners location in gothernburg";
        Double lat = 55.0;
        Double lng = 14.0;
        Actvity activity = new Actvity(title, type, description,lat,lng);
    }

    @Test
    @DisplayName("Testing the Constructor")
    void testConstructor(){
        String title =  "Runner";
        String type = "Jogging";
        String description = "The best runners location in gothernburg";
        Double lat = 55.0;
        Double lng = 14.0;
        Actvity actvity = new Actvity(title,type,description,lat,lng);
    }
    @Test
    @DisplayName("Testing the Setting values")
    void SetValues() {

    }
    @Test
    @DisplayName("Testing the getting values")
    void getValues(){

    }


}
