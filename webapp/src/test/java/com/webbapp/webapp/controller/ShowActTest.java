package com.webbapp.webapp.controller;


import com.webbapp.webapp.controller.activity.ShowActivitys;
import com.webbapp.webapp.model.entity.ActivityEntity;
import com.webbapp.webapp.model.entity.AppUserEntity;
import com.webbapp.webapp.model.entity.LocationEntity;
import com.webbapp.webapp.model.facade.ActivityFacade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * @author Adam Grandén
 * The  test should test the info from getting
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
    private AppUserEntity appUsersEntity;

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

        showActTest.appUsersEntity = new AppUserEntity();
        MockitoAnnotations.initMocks(showActTest.appUsersEntity);
    }

    /***
     *  Test method to check the locationEntity
     */

    @Test
    @DisplayName("Test LocationEntity")
    public void checkgetsandSetterslocationeneinty() {
        Double latitude = 55.0;
        Double longitude = 11.0;
        String city = "Gothenburg";

        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setLatitude(latitude);
        locationEntity.setLongitude(longitude);
        locationEntity.setCity(city);

        Assert.assertEquals(latitude,(Double)locationEntity.getLatitude());
        Assert.assertEquals(longitude, (Double) locationEntity.getLongitude());
        Assert.assertEquals(city,locationEntity.getCity());
    }

    /***
     *  Test method to check the AppUsersEntity
     */

    @Test
    @DisplayName("Test AppUsersEntity")
    public void checkgetsandSettersAppuserseneinty() {
        String username ="Alice1234";
        String password ="12345";

        AppUserEntity usersEntity = new AppUserEntity();
        usersEntity.setUserName(username);
        usersEntity.setUserPassword(password);

        Assert.assertEquals(username,usersEntity.getUserName());
        Assert.assertEquals(password,usersEntity.getUserPassword());

    }

    /**
     * Test if the value can't be found by the Integer
     */


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

        Double longitude =locationEntity.getLongitude();
        verify(locationEntity,times(1)).getLongitude();
        Assert.assertEquals(longitude,longitiude);

        Double latitude = locationEntity.getLatitude();
        verify(locationEntity,times(1)).getLatitude();
        Assert.assertEquals( latitiute, latitude);

        String loc_city = locationEntity.getCity();
        verify(locationEntity,times(1)).getCity();
        Assert.assertEquals(loc_city,city);

        String userName = "Alice1234";
        String userPassword = "12345";

        appUsersEntity =mock(AppUserEntity.class);
        when(appUsersEntity.getUserName()).thenReturn(userName);
        when(appUsersEntity.getUserPassword()). thenReturn(userPassword);

        String username = appUsersEntity.getUserName();
        verify(appUsersEntity, times(1)).getUserName();
        Assert.assertEquals( username, userName);

        String userpasssword =appUsersEntity.getUserPassword();
        verify(appUsersEntity).getUserName();
        Assert.assertEquals( userpasssword, userPassword);

        activityFacade = mock(ActivityFacade.class);
        when(activityFacade.find(1)).thenReturn(activityEntity);

        ActivityEntity activityEntity1 = activityFacade.find(1);
        verify(activityFacade).find(1);

        Assert.assertEquals(activityEntity1, activityEntity);

        showActivitys= mock(ShowActivitys.class);
        when(showActivitys.onload()).thenReturn("index");
        String onload = showActivitys.onload();

        verify(showActivitys).onload();


        Assert.assertEquals(onload,"index");
    }


    /**
     * Test if the value can be found by the Integer
     */

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

        Double longitude =locationEntity.getLongitude();
        verify(locationEntity,times(1)).getLongitude();
        Assert.assertEquals(longitude,longitiude);

        Double latitude = locationEntity.getLatitude();
        verify(locationEntity,times(1)).getLatitude();
        Assert.assertEquals( latitiute, latitude);

        String loc_city = locationEntity.getCity();
        verify(locationEntity,times(1)).getCity();
        Assert.assertEquals(loc_city,city);



        String userName = "Alice1234";
        String userPassword = "12345";

        appUsersEntity =mock(AppUserEntity.class);
        when(appUsersEntity.getUserName()).thenReturn(userName);
        when(appUsersEntity.getUserPassword()). thenReturn(userPassword);

        String username = appUsersEntity.getUserName();
        verify(appUsersEntity, times(1)).getUserName();
        Assert.assertEquals( username, userName);

        String userpasssword =appUsersEntity.getUserPassword();
        verify(appUsersEntity).getUserName();
        Assert.assertEquals( userpasssword, userPassword);


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
        verify(activityEntity,times(1)).getTitle();

        Assert.assertEquals(activityEntity.getAppUsersByUserId(), appUsersEntity);
        verify(activityEntity,times(1)).getAppUsersByUserId();

        Assert.assertEquals(activityEntity.getDescription(),description);
        verify(activityEntity,times(1)).getDescription();

        Assert.assertEquals(activityEntity.getType(), type);
        verify(activityEntity,times(1)).getType();

        Assert.assertEquals(activityEntity.getLocationByLocationId(),locationEntity);
        verify(activityEntity,times(1)).getLocationByLocationId();

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