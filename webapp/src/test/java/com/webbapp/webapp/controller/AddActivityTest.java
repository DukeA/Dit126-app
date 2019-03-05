package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.AddActivityFacade;
import com.webbapp.webapp.model.UsersFacade;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class AddActivityTest {

    @Test
    @DisplayName("Activity Test")
    public void testActivity(){
        AddActivity ac = new AddActivity();
        ac.add();

    }

    public class MockAddActivity extends AddActivity{

        AddActivityFacade activityFacade = new MockAddActivityFacade();
        UsersFacade usersFacade = new UsersFacade();

    }

    public class MockAddActivityFacade extends AddActivityFacade{



    }
}
