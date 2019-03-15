package com.webbapp.webapp.controller;

import com.webbapp.webapp.controller.activity.ActivityType;
import com.webbapp.webapp.controller.activity.EditActivity;
import com.webbapp.webapp.controller.login.AppUserSession;
import com.webbapp.webapp.model.entity.ActivityEntity;
import com.webbapp.webapp.model.entity.AppUserEntity;
import com.webbapp.webapp.model.entity.LocationEntity;
import com.webbapp.webapp.model.facade.ActivityFacade;
import com.webbapp.webapp.model.facade.LocationFacade;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EditActivityTest {

    @InjectMocks
    private EditActivity ac;

    @Mock
    private ActivityFacade activityFacade;
    @Mock
    private LocationFacade locationFacade;
    @Mock
    private AppUserSession userSession;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Getter setter test")
    public void gettersTest(){
        AppUserEntity user = new AppUserEntity();
        user.setUserName("Alice");
        user.setUserPassword("alice_password");
        when(userSession.getUser()).thenReturn(user);

        ac.setTitle("Hello");
        ac.setDescription("Desc");
        ac.setLat("57.710532072641925");
        ac.setLng("11.958837619599421");
        ac.setType(ActivityType.RUNNING);

        assertEquals("Hello", ac.getTitle());
        assertEquals("Desc", ac.getDescription());
        assertEquals("57.710532072641925", ac.getLat());
        assertEquals("11.958837619599421", ac.getLng());
        assertEquals(ac.getType(), ActivityType.RUNNING);
    }

    @Test
    @DisplayName("Loading test")
    public void LoadingActivity(){
        AppUserEntity user = new AppUserEntity();
        user.setUserName("Alice");
        user.setUserPassword("alice_password");
        when(userSession.getUser()).thenReturn(user);

        ActivityEntity activity = new ActivityEntity();
        activity.setType(ActivityType.SKIING.name());
        activity.setTitle("Test");
        activity.setDescription("Desc");
        LocationEntity loc = new LocationEntity();
        loc.setLatitude(1);
        loc.setLongitude(2);
        activity.setLocationByLocationId(loc);
        activity.setAppUsersByUserId(user);

        ac.setId("1");
        when(activityFacade.find(1)).thenReturn(activity);

        ac.onLoad();

        assertEquals("Test", ac.getTitle());
        assertEquals("Desc", ac.getDescription());
        assertEquals("1.0", ac.getLat());
        assertEquals("2.0", ac.getLng());
        assertEquals(ActivityType.SKIING, ac.getType());

    }

    @Test
    @DisplayName("Add Test")
    public void testActivity(){
        AppUserEntity user = new AppUserEntity();
        user.setUserName("Alice");
        user.setUserPassword("alice_password");
        when(userSession.getUser()).thenReturn(user);

        ActivityEntity activity = new ActivityEntity();
        activity.setType(ActivityType.CYCLING.name());
        activity.setTitle("Test");
        activity.setDescription("Desc");
        LocationEntity loc = new LocationEntity();
        loc.setLatitude(1);
        loc.setLongitude(2);
        activity.setLocationByLocationId(loc);
        activity.setAppUsersByUserId(user);

        ac.setId("1");
        when(activityFacade.find(1)).thenReturn(activity);

        ac.onLoad();

        ac.edit();

        verify(activityFacade).edit(argThat((ActivityEntity ac) -> ac.getTitle().equals("Test")
                                                                                && ac.getDescription().equals("Desc")
                                                                                && ac.getType().equals(ActivityType.CYCLING.name())
                                                                                && ac.getLocationByLocationId().getLatitude() == 1.0
                                                                                && ac.getLocationByLocationId().getLongitude() == 2.0
                                                                                && ac.getAppUsersByUserId().getUserName().equals("Alice")));

    }

    @Test
    @DisplayName("Edit invalid activity")
    public void addInvalidActivity(){
        AppUserEntity user = new AppUserEntity();
        user.setUserName("Alice");
        user.setUserPassword("alice_password");
        when(userSession.getUser()).thenReturn(user);

        ActivityEntity activity = new ActivityEntity();
        activity.setType(ActivityType.CYCLING.name());
        activity.setTitle(null);
        activity.setDescription("Desc");
        LocationEntity loc = new LocationEntity();
        loc.setLatitude(1);
        loc.setLongitude(2);
        activity.setLocationByLocationId(loc);
        activity.setAppUsersByUserId(user);

        ac.setId("1");
        when(activityFacade.find(1)).thenReturn(activity);

        ac.onLoad();

        ac.edit();

        verify(activityFacade, never()).edit(Mockito.any());
    }


    @Test
    @DisplayName("Add not loggedin activity")
    public void notLoggedinActivity(){
        when(userSession.getUser()).thenReturn(null);

        ActivityEntity activity = new ActivityEntity();
        activity.setType(ActivityType.RUNNING.name());
        activity.setTitle("Title");
        activity.setDescription("Desc");
        LocationEntity loc = new LocationEntity();
        loc.setLatitude(1);
        loc.setLongitude(2);
        activity.setLocationByLocationId(loc);
        activity.setAppUsersByUserId(null);

        ac.setId("1");
        when(activityFacade.find(1)).thenReturn(activity);

        String redirect = ac.onLoad();

        assertEquals("index.xhtml", redirect);

        ac.edit();
        verify(activityFacade, never()).edit(Mockito.any());
    }

    @Test
    @DisplayName("Not owner of activity direct")
    public void notOwnerOfActivityDirect(){
        AppUserEntity user = new AppUserEntity();
        user.setUserName("Alice");
        user.setUserPassword("alice_password");
        when(userSession.getUser()).thenReturn(user);

        AppUserEntity user2 = new AppUserEntity();
        user.setUserName("Bob");
        user.setUserPassword("bob_password");

        ActivityEntity activity = new ActivityEntity();
        activity.setType(ActivityType.RUNNING.name());
        activity.setTitle("Test");
        activity.setDescription("Desc");
        LocationEntity loc = new LocationEntity();
        loc.setLatitude(57.710532072641925);
        loc.setLongitude(11.958837619599421);
        activity.setLocationByLocationId(loc);
        activity.setAppUsersByUserId(user2);

        ac.setId("1");
        when(activityFacade.find(1)).thenReturn(activity);

        ac.edit();
        verify(activityFacade, never()).edit(Mockito.any());
    }

    @Test
    @DisplayName("Not owner of activity")
    public void notOwnerOfActivity(){
        AppUserEntity user = new AppUserEntity();
        user.setUserName("Alice");
        user.setUserPassword("alice_password");
        when(userSession.getUser()).thenReturn(user);

        AppUserEntity user2 = new AppUserEntity();
        user.setUserName("Bob");
        user.setUserPassword("bob_password");

        ActivityEntity activity = new ActivityEntity();
        activity.setType(ActivityType.RUNNING.name());
        activity.setTitle("Test");
        activity.setDescription("Desc");
        LocationEntity loc = new LocationEntity();
        loc.setLatitude(57.710532072641925);
        loc.setLongitude(11.958837619599421);
        activity.setLocationByLocationId(loc);
        activity.setAppUsersByUserId(user2);

        ac.setId("1");
        when(activityFacade.find(1)).thenReturn(activity);

        String redirect = ac.onLoad();

        assertEquals("index.xhtml", redirect);


        ac.edit();
        verify(activityFacade, never()).edit(Mockito.any());
    }

    @Test
    @DisplayName("Add not loggedin activity")
    public void notLoggedinDirectActivity(){
        when(userSession.getUser()).thenReturn(null);

        ActivityEntity activity = new ActivityEntity();
        activity.setType(ActivityType.RUNNING.name());
        activity.setTitle("Title");
        activity.setDescription("Desc");
        LocationEntity loc = new LocationEntity();
        loc.setLatitude(1);
        loc.setLongitude(2);
        activity.setLocationByLocationId(loc);
        activity.setAppUsersByUserId(null);

        ac.setId("1");
        when(activityFacade.find(1)).thenReturn(activity);

        ac.edit();
        verify(activityFacade, never()).edit(Mockito.any());
    }

    @Test
    @DisplayName("City test")
    public void correctCityName(){
        AppUserEntity user = new AppUserEntity();
        user.setUserName("Alice");
        user.setUserPassword("alice_password");
        when(userSession.getUser()).thenReturn(user);

        ActivityEntity activity = new ActivityEntity();
        activity.setType(ActivityType.RUNNING.name());
        activity.setTitle("Test");
        activity.setDescription("Desc");
        LocationEntity loc = new LocationEntity();
        loc.setLatitude(57.710532072641925);
        loc.setLongitude(11.958837619599421);
        activity.setLocationByLocationId(loc);
        activity.setAppUsersByUserId(user);

        ac.setId("1");
        when(activityFacade.find(1)).thenReturn(activity);

        ac.onLoad();

        ac.edit();

        verify(activityFacade).edit(argThat((ActivityEntity ac) -> ac.getTitle().equals("Test")
                && ac.getDescription().equals("Desc")
                && ac.getType().equals(ActivityType.RUNNING.name())
                && ac.getLocationByLocationId().getLatitude() == 57.710532072641925
                && ac.getLocationByLocationId().getLongitude() == 11.958837619599421
                && ac.getAppUsersByUserId().getUserName().equals("Alice")
                && ac.getLocationByLocationId().getCity().equals("gothenburg")));

    }
}
