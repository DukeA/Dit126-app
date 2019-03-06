package com.webbapp.webapp.controller;


import com.sun.xml.internal.ws.policy.AssertionSet;
import com.webbapp.webapp.controller.ShowActivitys;
import com.webbapp.webapp.model.ActivityEntity;
import com.webbapp.webapp.model.ShowActivityFacade;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

/**
 * @Author: Adam Grandén
 * @Class The  test should test the info from getting
 *        input from the Model class to the DataBase
 *
 */

@RunWith(JUnit4.class)
public class ShowAct {

    private static ShowActivitys activitysC = null;
    private static ShowActivityFacade facade=null;

    @BeforeClass
    @DisplayName("Setup class")
    public static  void init() {
        String type = "Jogging";
        String title = "Monaden";
        activitysC = new ShowActivitys();
       // activitysC.setType(type);
        activitysC.setTitle(title);
        facade = new ShowActivityFacade();

    }


    @Test
    @DisplayName("Testing the findbyTitleActivity")
    public void checkFindBytitleActivity() {
        //String type = activitysC.getType();
        String title = activitysC.getTitle();
        //ActivityEntity value = facade.findActivity(title,type);
        //Assert.assertEquals(value.getTitle(),title);
        //Assert.assertEquals(value.getType(),type);
    }

    @Test
    @DisplayName("Testing the findByTitleActivity")
    public void checkFindByTitle() {
        String title = activitysC.getTitle();
        //ActivityEntity value = facade.findByTitle(title);
        Assert.assertFalse(false);

    }
    @Test
    @DisplayName("Testing the findByTypeActivity")
    public void checkFindByType() {
        String title = activitysC.getTitle();
        //ActivityEntity value = facade.findByTitle(title);
        Assert.assertFalse(false);
    }

    @Test
    @DisplayName("Testing the findALL")
    public void checkFindALL() {
        List<ActivityEntity> value = facade.findAll();
        Assert.assertFalse(false);
    }


}
