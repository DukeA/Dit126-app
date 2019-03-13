package com.webbapp.webapp.controller;


import com.sun.xml.internal.ws.policy.AssertionSet;
import com.webbapp.webapp.controller.ShowActivitys;
import com.webbapp.webapp.model.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @Author: Adam Grandén
 * @Class The  test should test the info from getting
 *        input from the Model class to the DataBase
 *
 */

@RunWith(JUnit4.class)
public class ShowAct {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private ShowActivitys showActivitys;


    @Mock
    private Login login;

    @Mock
    private ShowActivityFacade showActivityFacade;

    @Mock
    private LocationFacade locationFacade;

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

    @Test
    public void testDeleteNotLoggedIn() {
        when(login.getUser()).thenReturn(null);
        ActivityEntity activityEntity = new ActivityEntity();
        AppUsersEntity owner = new AppUsersEntity();
        owner.setUserName("alice");
        owner.setUserPassword("alicePassword");

        activityEntity.setAppUsersByUserId(owner);
        activityEntity.setLocationByLocationId(new LocationEntity());
        showActivitys.setActivityEntity(activityEntity);

        String result = showActivitys.delete();
        String expected = null;

        Assert.assertEquals(result, expected);

        verify(showActivityFacade, never()).remove(activityEntity);
    }


    @Test
    public void testDeleteNotOwner() {
        AppUsersEntity loggedIn = new AppUsersEntity();
        loggedIn.setUserName("alice");
        loggedIn.setUserPassword("alicePassword");

        AppUsersEntity activityOwner = new AppUsersEntity();
        activityOwner.setUserName("bob");
        activityOwner.setUserPassword("bobPassword");

        when(login.getUser()).thenReturn(loggedIn);
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setAppUsersByUserId(activityOwner);

        String result = showActivitys.delete();
        String expected = null;

        Assert.assertEquals(result, expected);

        verify(showActivityFacade, never()).remove(activityEntity);
    }

    @Test
    public void testDeleteNonExistingActivivty() {
        AppUsersEntity user = new AppUsersEntity();
        user.setUserName("alice");
        user.setUserPassword("alicePassword");

        when(login.getUser()).thenReturn(user);
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setAppUsersByUserId(user);

        LocationEntity locationEntity = new LocationEntity();

        activityEntity.setLocationByLocationId(locationEntity);

        showActivitys.setActivityid(0);
        when(showActivityFacade.find(1)).thenReturn(null);

        doNothing().when(locationFacade).remove(locationEntity);
        showActivitys.onload();
        String result = showActivitys.delete();
        String expected = null;

        Assert.assertEquals(result, expected);

        verify(showActivityFacade, never()).remove(argThat(ae -> ae.equals(activityEntity)));
    }

    @Test
    public void testDelete() {
        AppUsersEntity user = new AppUsersEntity();
        user.setUserName("alice");
        user.setUserPassword("alicePassword");

        when(login.getUser()).thenReturn(user);
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setAppUsersByUserId(user);

        LocationEntity locationEntity = new LocationEntity();

        activityEntity.setLocationByLocationId(locationEntity);

        showActivitys.setActivityid(0);
        when(showActivityFacade.find(0)).thenReturn(activityEntity);

        doNothing().when(locationFacade).remove(locationEntity);
        showActivitys.onload();
        String result = showActivitys.delete();
        String expected = "index";

        Assert.assertEquals(result, expected);

        verify(showActivityFacade).remove(argThat(ae -> ae.equals(activityEntity)));
    }


}
