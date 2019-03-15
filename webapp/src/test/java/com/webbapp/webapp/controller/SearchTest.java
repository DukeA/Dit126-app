package com.webbapp.webapp.controller;

import com.webbapp.webapp.controller.search.Search;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchTest {

    private Search search;

    @Before
    public void setUp() {
        search = new Search();
    }

    @Test
    public void testCapitalisedString() {
        String s = "GOTHENBURG";
        search.setText(s);
//        search.prepareString();
        assertEquals(s.toLowerCase(), search.getText());
    }

    @Test
    public void testWhitespaceString() {
        String s = " GoThEnBuRg       ";
        search.setText(s);
//        search.prepareString();
        assertEquals("gothenburg", search.getText());
    }

}
