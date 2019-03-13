package com.webbapp.webapp.test;

//import com.webbapp.webapp.model.Actvity;
import com.webbapp.webapp.model.ActivityEntity;
import com.webbapp.webapp.model.AppUserEntity;
import com.webbapp.webapp.model.LocationEntity;
import javafx.beans.binding.When;
import org.eclipse.jdt.internal.compiler.ast.AssertStatement;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;


/**
 * @Author: Adam Grandén
 * @Class: The class is an structure of the code is to  create the testcode.
 */
@RunWith(JUnit4.class)
public class ActivityTest {

    private static ActivityEntity actvity;

    @BeforeClass
    public static void init() {


        LocationEntity locationEntity = mock (LocationEntity.class);
        actvity = mock(ActivityEntity.class);
    }

    /***
     * Test the method for the Activity entity
     */
    @Test
    @DisplayName("Testing the Activity Entity")
    public void testConstructor(){
        String title =  "Runner";
        String type = "Jogging";
        String description = "The best running location in goteborg";
        ActivityEntity act = actvity;

        ArrayList<Object> valuelist = new ArrayList<Object>(Arrays.asList(title, type, description));
        when(act.getTitle()).thenReturn((String)valuelist.get(0));
        when(act.getType()).thenReturn((String)valuelist.get(1));
        when(act.getDescription()).thenReturn((String)valuelist.get(2));

        doCallRealMethod().when(act).setTitle(any(String.class));
        doCallRealMethod().when(act).setType(any(String.class));
        doCallRealMethod().when(act).setDescription(any(String.class));

        act.setDescription(description);
        verify(act,times(1)).setDescription(description);

        act.setType(type);
        verify(act,times(1)).setType(type);

        act.setTitle(title);
        verify(act,times(1)).setTitle(title);

       ArrayList<Object> value2 = new ArrayList<>(
               Arrays.asList(
                       act.getTitle(),
                       act.getType(),
                       act.getDescription()));
        verify(act,times(1)).getTitle();
        verify(act,times(1)).getType();
        verify(act,times(1)).getDescription();

        Assert.assertArrayEquals("Check the Constructor", valuelist.toArray(), value2.toArray());
    }

    /***
     * Test the method for the Location entity
     */

    @Test
    @DisplayName("Check the LocationEntity for the Location")
    public void CheckLocationEninty() {
        Double lat =55.0;
        Double lon =11.0;
        String City ="GOTHENBURG";

        LocationEntity locationEntity = mock(LocationEntity.class);

        when(locationEntity.getLongitude()).thenReturn(lon);
        when(locationEntity.getLatitude()).thenReturn(lat);
        when(locationEntity.getCity()).thenReturn(City);

        doCallRealMethod().when(locationEntity).setLongitude(any(Double.class));
        doCallRealMethod().when(locationEntity).setLatitude(any(Double.class));
        doCallRealMethod().when(locationEntity).setCity(any(String.class));

        locationEntity.setCity(City);
        verify(locationEntity,times(1)).setCity(City);

        locationEntity.setLatitude(lat);
        verify(locationEntity,times(1)).setLatitude(lat);

        locationEntity.setLongitude(lon);
        verify(locationEntity,times(1)).setLongitude(lon);

        Assert.assertEquals(lon,(Double)locationEntity.getLongitude());
        verify(locationEntity,times(1)).getLongitude();

        Assert.assertEquals(lat,(Double)locationEntity.getLatitude());
        verify(locationEntity,times(1)).getLatitude();

        Assert.assertEquals(City,locationEntity.getCity());
        verify(locationEntity,times(1)).getCity();

    }

    /***
     * Test the method for the AppUsers entity
     */

    @Test
    @DisplayName("Test the AppUserEntity ")
    public void TestUser() {
        String user ="Alice123";
        String passwd ="1234";

        AppUserEntity appUsersEntity = mock(AppUserEntity.class);
        when(appUsersEntity.getUserName()).thenReturn(user);
        when(appUsersEntity.getUserPassword()).thenReturn(passwd);

        doCallRealMethod().when(appUsersEntity).setUserName(any(String.class));
        doCallRealMethod().when(appUsersEntity).setUserPassword(any(String.class));

        appUsersEntity.setUserName(user);
        verify(appUsersEntity,times(1)).setUserName(user);

        appUsersEntity.setUserPassword(passwd);
        verify(appUsersEntity,times(1)).setUserPassword(passwd);

        String Username = appUsersEntity.getUserName();
        verify(appUsersEntity,times(1)).getUserName();
        Assert.assertEquals(Username,user);

        String Password = appUsersEntity.getUserPassword();
        verify(appUsersEntity,times(1)).getUserPassword();
        Assert.assertEquals(passwd,Password);
    }

    /***
     * Check if the setters and getters work together
     */

    @Test
    @DisplayName("Test the attribute together")
    public void TestBoth() {

        String title ="Runner";
        String type = "Jogging";
        String description ="The best running location in goteborg";
        Double lat = 55.0;
        Double lon =11.0;
        String City ="GOTHENBURG";
        String user ="Alice123";
        String passwd ="12345";

        LocationEntity locationEntity = mock(LocationEntity.class);

        when(locationEntity.getLatitude()).thenReturn(lat);
        when(locationEntity.getLongitude()).thenReturn(lon);
        when(locationEntity.getCity()).thenReturn(City);

        locationEntity.setCity(City);
        verify(locationEntity,times(1)).setCity(City);

        locationEntity.setLatitude(lat);
        verify(locationEntity,times(1)).setLatitude(lat);

        locationEntity.setLongitude(lon);
        verify(locationEntity,times(1)).setLongitude(lon);

        String locCity = locationEntity.getCity();
        Double loclat = locationEntity.getLatitude();
        Double loclon = locationEntity.getLongitude();

        Assert.assertEquals(loclon,lon);
        verify(locationEntity,times(1)).getLongitude();

        Assert.assertEquals(loclat,lat);
        verify(locationEntity,times(1)).getLatitude();

        Assert.assertEquals(locCity,City);
        verify(locationEntity,times(1)).getCity();

        AppUserEntity appUsersEntity = mock(AppUserEntity.class);
        when(appUsersEntity.getUserName()).thenReturn(user);
        when(appUsersEntity.getUserPassword()).thenReturn(passwd);

        doCallRealMethod().when(appUsersEntity).setUserName(any(String.class));
        doCallRealMethod().when(appUsersEntity).setUserPassword(any(String.class));

        appUsersEntity.setUserName(user);
        verify(appUsersEntity,times(1)).setUserName(user);

        appUsersEntity.setUserPassword(passwd);
        verify(appUsersEntity,times(1)).setUserPassword(passwd);

        String Username = appUsersEntity.getUserName();
        verify(appUsersEntity,times(1)).getUserName();
        Assert.assertEquals(Username,user);

        String Password = appUsersEntity.getUserPassword();
        verify(appUsersEntity,times(1)).getUserPassword();
        Assert.assertEquals(passwd,Password);

        ActivityEntity activityEntity = mock(ActivityEntity.class);
        when(activityEntity.getTitle()).thenReturn(title);
        when(activityEntity.getType()).thenReturn(type);
        when(activityEntity.getDescription()).thenReturn(description);
        when(activityEntity.getLocationByLocationId()).thenReturn(locationEntity);
        when(activityEntity.getAppUsersByUserId()).thenReturn(appUsersEntity);

        doCallRealMethod().when(activityEntity).setTitle(title);
        doCallRealMethod().when(activityEntity).setType(type);
        doCallRealMethod().when(activityEntity).setDescription(description);
        doCallRealMethod().when(activityEntity).setAppUsersByUserId(appUsersEntity);
        doCallRealMethod().when(activityEntity).setLocationByLocationId(locationEntity);

        activityEntity.setLocationByLocationId(locationEntity);
        verify(activityEntity,times(1)).setLocationByLocationId(locationEntity);
        activityEntity.setAppUsersByUserId(appUsersEntity);
        verify(activityEntity,times(1)).setAppUsersByUserId(appUsersEntity);
        activityEntity.setDescription(description);
        verify(activityEntity,times(1)).setDescription(description);
        activityEntity.setType(type);
        verify(activityEntity,times(1)).setType(type);
        activityEntity.setTitle(title);
        verify(activityEntity,times(1)).setTitle(title);

        String act_Title = activityEntity.getTitle();
        verify(activityEntity,times(1)).getTitle();
        Assert.assertEquals(act_Title,title);

        String act_description = activityEntity.getDescription();
        verify(activityEntity,times(1)).getDescription();
        Assert.assertEquals(act_description,description);

        String act_type = activityEntity.getType();
        verify(activityEntity,times(1)).getType();
        Assert.assertEquals(act_type,type);

        LocationEntity locEninty = activityEntity.getLocationByLocationId();
        verify(activityEntity,times(1)).getLocationByLocationId();
        Assert.assertEquals(locationEntity,locEninty);

        AppUserEntity appUsersEntity1 = activityEntity.getAppUsersByUserId();
        verify(activityEntity,times(1)).getAppUsersByUserId();
        Assert.assertEquals(appUsersEntity1,appUsersEntity);


    }


}
