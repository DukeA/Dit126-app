package com.webbapp.webapp.test;


import com.webbapp.webapp.controller.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        ActivityTest.class,
        AddActivityTest.class,
        EditActivityTest.class,
        ShowActTest.class,
        RegisterFacadeTest.class
})

public class testSuite {


}
