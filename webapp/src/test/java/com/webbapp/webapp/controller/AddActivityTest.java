package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.*;

public class AddActivityTest {

    @InjectMocks
    private AddActivity ac;

    @Mock
    private AddActivityFacade activityFacade;
    @Mock
    private Login login;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    @DisplayName("User not logged in")
    public void notLoggedInActivity(){
        when(login.getUser()).thenReturn(null);

        String redirect = ac.onLoad();

        assertEquals("index.xhtml", redirect);
    }

    @Test
    @DisplayName("Add Test")
    public void testActivity(){
        AppUsersEntity user = new AppUsersEntity();
        user.setUserName("Alice");
        user.setUserPassword("alice_password");
        when(login.getUser()).thenReturn(user);

        String redirect = ac.onLoad();
        assertEquals(null, redirect);

        ac.setTitle("Hello");
        ac.setDescription("Desc");
        ac.setLat("1.2");
        ac.setLng("2.5");
        ac.setType(ActivityType.TYPE1);

        ac.add();

        verify(activityFacade).create(argThat((ActivityEntity activity) -> activity.getTitle().equals("Hello")
                                                                                && activity.getDescription().equals("Desc")
                                                                                && activity.getType().equals(ActivityType.TYPE1.name())
                                                                                && activity.getLocationByLocationId().getLatitude() == 1.2
                                                                                && activity.getLocationByLocationId().getLongitude() == 2.5
                                                                                && activity.getAppUsersByUserId().getUserName().equals("Alice")));

    }

    @Test
    @DisplayName("Add invalid activity")
    public void addInvalidActivity(){
        AppUsersEntity user = new AppUsersEntity();
        user.setUserName("Alice");
        user.setUserPassword("alice_password");
        when(login.getUser()).thenReturn(user);

        ac.setDescription("Desc");
        ac.setLat("1.2");
        ac.setLng("2.5");
        ac.setType(ActivityType.TYPE1);

        ac.add();

        verify(activityFacade, never()).create(Mockito.any());
    }


    @Test
    @DisplayName("Add not loggedin activity")
    public void notLoggedinActivity(){
        AppUsersEntity user = null;
        when(login.getUser()).thenReturn(user);

        ac.setDescription("Desc");
        ac.setLat("1.2");
        ac.setLng("2.5");
        ac.setType(ActivityType.TYPE1);

        ac.add();

        verify(activityFacade, never()).create(Mockito.any());
    }

    @Test
    @DisplayName("City test")
    public void correctCityName(){
        AppUsersEntity user = new AppUsersEntity();
        user.setUserName("Alice");
        user.setUserPassword("alice_password");
        when(login.getUser()).thenReturn(user);

        ac.setTitle("Hello");
        ac.setDescription("Desc");
        ac.setLat("57.710532072641925");
        ac.setLng("11.958837619599421");
        ac.setType(ActivityType.TYPE5);

        ac.add();

        verify(activityFacade).create(argThat((ActivityEntity activity) -> activity.getTitle().equals("Hello")
                && activity.getDescription().equals("Desc")
                && activity.getType().equals(ActivityType.TYPE5.name())
                && activity.getLocationByLocationId().getLatitude() == 57.710532072641925
                && activity.getLocationByLocationId().getLongitude() == 11.958837619599421
                && activity.getAppUsersByUserId().getUserName().equals("Alice")
                && activity.getLocationByLocationId().getCity().equals("gothenburg")));

    }

    @Test
    @DisplayName("Getter setter test")
    public void gettersTest(){
        AppUsersEntity user = new AppUsersEntity();
        user.setUserName("Alice");
        user.setUserPassword("alice_password");
        when(login.getUser()).thenReturn(user);

        ac.setTitle("Hello");
        ac.setDescription("Desc");
        ac.setLat("57.710532072641925");
        ac.setLng("11.958837619599421");
        ac.setType(ActivityType.TYPE5);

        ac.add();

        assertEquals("Hello", ac.getTitle());
        assertEquals("Desc", ac.getDescription());
        assertEquals("57.710532072641925", ac.getLat());
        assertEquals("11.958837619599421", ac.getLng());
        assertEquals(ac.getType(), ActivityType.TYPE5);
    }

}
