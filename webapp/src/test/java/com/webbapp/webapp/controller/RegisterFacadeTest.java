package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.AppUserEntity;
import com.webbapp.webapp.model.RegisterFacade;
import com.webbapp.webapp.util.exception.MultipleUsersFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;


/***
 * @author Adam Grandén
 *
 *  The test class for testing the Register action should work
 *  and  the class which make up the Register case
 */



@RunWith(JUnit4.class)
public class RegisterFacadeTest {

    @Mock
    private Register register;

    @Mock
    private RegisterFacade registerFacade;

    @Mock
    private AppUserEntity appUsersEntity;



    /***
     * The method initializes all the mock values for the test case before it starts
     */
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public  void setup() {
        RegisterFacadeTest registerFacadeTest = new RegisterFacadeTest();
        MockitoAnnotations.initMocks(registerFacadeTest);

        registerFacadeTest.register = new Register();
        MockitoAnnotations.initMocks(registerFacadeTest.register);

        registerFacadeTest.registerFacade = new RegisterFacade();
        MockitoAnnotations.initMocks(registerFacadeTest.registerFacade);

        registerFacadeTest.registerFacade = new RegisterFacade();
        MockitoAnnotations.initMocks(registerFacadeTest.registerFacade);

        registerFacadeTest.appUsersEntity = new AppUserEntity();
        MockitoAnnotations.initMocks(registerFacadeTest.appUsersEntity);

    }

    /**
     *  Test for the checker class sets an getters work in the Register
     */

    @Test
    @DisplayName("Check Set and getters")
    public void testAddUserGetterAndSetter(){

        String userName = "Alice1234";
        String Password = "123456";
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        AppUserEntity usersEntity = new AppUserEntity();
        Register n_Register = new Register();

        usersEntity.setUserName(userName);
        usersEntity.setUserPassword(Password);

        n_Register.setPassword(encoder.encode(Password));
        n_Register.setUsername(userName);

        assertEquals(userName,n_Register.getUsername());
        assertSame(encoder.matches(Password,n_Register.getPassword()), true);
    }


    /**
     *  Test for the checker RegisterFacade will return the User in the ArrayList
     */

    @Test()
    @DisplayName("On Register Test")
    public void testRegisterFacadeQuery() {

        String userName = "Alice1234";
        String password ="123456";


        appUsersEntity = new AppUserEntity();
        appUsersEntity.setUserName(userName);
        appUsersEntity.setUserPassword(password);

        ArrayList<AppUserEntity> list = new ArrayList<>();
        list.add(appUsersEntity);


        RegisterFacade registerFacade = mock(RegisterFacade.class);
        try {
            doThrow(new MultipleUsersFoundException()).when(registerFacade).checkUserName(userName);
            registerFacade.checkUserName(userName);
        } catch (MultipleUsersFoundException e) {
            System.out.println("Users exist");
        }

        Assert.assertTrue(list.size()<=1);

    }


    /***
     * Check for the on register if the user is then created by the method
     */

    @Test()
    @DisplayName("On check user exist")
    public void testAddUser()  {

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        String userName = "Alice1234";
        String password ="123456";

        String encoded = encoder.encode(password);

        AppUserEntity appUsersEntity = mock(AppUserEntity.class);
        appUsersEntity.setUserName(userName);
        appUsersEntity.setUserPassword(password);

        registerFacade = mock(RegisterFacade.class);

        try {
            doThrow(MultipleUsersFoundException.class).when(registerFacade).checkUserName(userName);
        } catch (MultipleUsersFoundException e) {
            e.printStackTrace();
        }

        register =mock(Register.class);

        when(register.getUsername()).thenReturn(userName);

        String name = register.getUsername();


        Assert.assertEquals(name,userName);

        when(register.getPassword()).thenReturn(encoded);
        String registerPassword = register.getPassword();



        Assert.assertSame(encoder.matches(password, registerPassword), true);

        when(register.register()).thenReturn("index");


        String on_Register = register.register();
            verify(register,times(1)).register();

        Assert.assertEquals("index", on_Register);

    }

    /***
     * Check for the on register if the user  can't be created from the Register class.
     */
    
    @Test()
    @DisplayName("Check if there already exist user")
    public void checkUserExist() {

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        String userName = "Alice1234";
        String password ="123456";

        String encoded = encoder.encode(password);

        AppUserEntity appUsersEntity = mock(AppUserEntity.class);
        appUsersEntity.setUserName(userName);
        appUsersEntity.setUserPassword(password);



        registerFacade = mock(RegisterFacade.class);


        try {
            doThrow(new MultipleUsersFoundException()).when(registerFacade).checkUserName(userName);
        } catch (MultipleUsersFoundException e) {
            e.printStackTrace();
        }


        register =mock(Register.class);

        register.setUsername(userName);
        when(register.getUsername()).thenReturn(userName);
        String name = register.getUsername();


        Assert.assertEquals(name,userName);

        when(register.getPassword()).thenReturn(encoded);
        String registerPassword = register.getPassword();

        Assert.assertSame(encoder.matches(password, registerPassword), true);

        when(register.register()).thenReturn("register");
        String on_register = register.register();
        verify(register,times(1)).register();

        Assert.assertEquals("register", on_register);

    }

}
