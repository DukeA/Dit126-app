package com.webbapp.webapp.controller;


import com.sun.xml.internal.ws.policy.AssertionSet;
import com.webbapp.webapp.controller.ShowActivitys;
import com.webbapp.webapp.model.*;
import javafx.beans.binding.When;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.inject.Inject;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * @Author: Adam Grandén
 * @Class The  test should test the info from getting
 * input from the Model class to the DataBase
 */

@RunWith(JUnit4.class)
public class ShowActTest {

    @InjectMocks
    private ShowActivitys showActivitys;

    @Mock
    private ActivityFacade activityFacade;

    @Mock
    private ActivityEntity activityEntity;

    @Mock
    private LocationEntity locationEntity;

    @Mock
    private AppUsersEntity appUsersEntity;

    @Before
    @DisplayName("Setup class")
    public void init() {
        ShowActTest showActTest = new ShowActTest();
        MockitoAnnotations.initMocks(showActTest);

        showActTest.showActivitys = new ShowActivitys();
        MockitoAnnotations.initMocks(showActTest.showActivitys);

        showActTest.activityFacade = new ActivityFacade();
        MockitoAnnotations.initMocks(showActTest.activityFacade);

        showActTest.activityEntity = new ActivityEntity();
        MockitoAnnotations.initMocks(showActTest.activityEntity);

        showActTest.locationEntity = new LocationEntity();
        MockitoAnnotations.initMocks(showActTest.locationEntity);

        showActTest.appUsersEntity = new AppUsersEntity();
        MockitoAnnotations.initMocks(showActTest.appUsersEntity);
    }

    @Test
    @DisplayName("Can't find findByInteger")
    public void checkFindByIntegerActivityFacade() {
        Double latitiute = 55.0;
        Double longitiude = 11.0;
        String city = "Gothenburg";

        locationEntity = mock(LocationEntity.class);
        when(locationEntity.getCity()).thenReturn(city);
        when(locationEntity.getLongitude()).thenReturn(longitiude);
        when(locationEntity.getLatitude()).thenReturn(latitiute);

        String userName = "Alice1234";
        String userPassword = "12345";

        appUsersEntity =mock(AppUsersEntity.class);
        when(appUsersEntity.getUserName()).thenReturn(userName);
        when(appUsersEntity.getUserPassword()). thenReturn(userPassword);


        activityFacade = mock(ActivityFacade.class);
        when(activityFacade.find(1)).thenReturn(activityEntity);
        ActivityEntity activityEntity1 = activityFacade.find(1);

        Assert.assertEquals(activityEntity1, activityEntity);

        showActivitys= mock(ShowActivitys.class);
        when(showActivitys.onload()).thenReturn("index");
        String onload = showActivitys.onload();

        verify(showActivitys).onload();


        Assert.assertEquals(onload,"index");


    }





    @Test
    @DisplayName("Testing the findbyInteger")
    public void checkFindByIntegerActivity() {

        Double latitiute = 55.0;
        Double longitiude = 11.0;
        String city = "Gothenburg";

        locationEntity = mock(LocationEntity.class);
        when(locationEntity.getCity()).thenReturn(city);
        when(locationEntity.getLongitude()).thenReturn(longitiude);
        when(locationEntity.getLatitude()).thenReturn(latitiute);

        String userName = "Alice1234";
        String userPassword = "12345";

        appUsersEntity =mock(AppUsersEntity.class);
        when(appUsersEntity.getUserName()).thenReturn(userName);
        when(appUsersEntity.getUserPassword()). thenReturn(userPassword);

        String title = "Monaden";
        String type = "Jogging";
        String description ="";

        activityEntity =mock(ActivityEntity.class);
        when(activityEntity.getAppUsersByUserId()).thenReturn(appUsersEntity);
        when(activityEntity.getDescription()).thenReturn(description);
        when(activityEntity.getLocationByLocationId()).thenReturn(locationEntity);
        when(activityEntity.getType()).thenReturn(type);
        when(activityEntity.getTitle()).thenReturn(title);
        when(activityEntity.getActivityId()).thenReturn(1);

        Assert.assertEquals(activityEntity.getTitle(), title);
        Assert.assertEquals(activityEntity.getAppUsersByUserId(), appUsersEntity);
        Assert.assertEquals(activityEntity.getDescription(),description);
        Assert.assertEquals(activityEntity.getType(), type);
        Assert.assertEquals(activityEntity.getLocationByLocationId(),locationEntity);


        activityFacade = mock(ActivityFacade.class);
        when(activityFacade.find(1)).thenReturn(activityEntity);
        ActivityEntity activityEntity1 = activityFacade.find(1);

        Assert.assertEquals(activityEntity1, activityEntity);


        showActivitys= mock(ShowActivitys.class);
        when(showActivitys.onload()).thenReturn("ShowAct?faces-redirect=true");
        String onload = showActivitys.onload();

        verify(showActivitys).onload();
        
        Assert.assertEquals(onload,"ShowAct?faces-redirect=true");

    }



}
