package com.webbapp.webapp.test;


import com.webbapp.webapp.controller.ShowActTest;
import org.junit.jupiter.api.Test;
import com.webbapp.webapp.controller.RegisterFacadeTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        ActivityTest.class,
        ShowActTest.class
        RegisterFacadeTest.class
})
public class testSuite {


}
