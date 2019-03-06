package com.webbapp.webapp.test;


import com.webbapp.webapp.controller.RegisterFacadeTest;
import com.webbapp.webapp.controller.ShowAct;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        ActivityTest.class,
        ShowAct.class,
        RegisterFacadeTest.class
})
public class testSuite {


}
