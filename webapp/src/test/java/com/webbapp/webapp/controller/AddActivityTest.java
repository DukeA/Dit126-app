package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.*;

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
    @DisplayName("Add Test")
    public void testActivity(){
        AppUsersEntity user = new AppUsersEntity();
        user.setUserName("Alice");
        user.setUserPassword("alice_password");
        when(login.getUser()).thenReturn(user);

        ac.setTitle("Hello");
        ac.setDescription("Desc");
        ac.setLat("1.2");
        ac.setLng("2.5");
        ac.setType(ActivityType.TYPE1);

        ac.add();

        //verify(activityFacade).create(ent);
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

}
