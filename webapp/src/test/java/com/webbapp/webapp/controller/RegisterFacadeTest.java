package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.AppUsersEntity;
import com.webbapp.webapp.model.RegisterFacade;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    private AppUsersEntity appUsersEntity;

    @Mock
    private EntityManager entityManager;




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

        registerFacadeTest.appUsersEntity = new AppUsersEntity();
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
        AppUsersEntity usersEntity = new AppUsersEntity();
        Register n_regeister = new Register();

        usersEntity.setUserName(userName);
        usersEntity.setUserPassword(Password);

        n_regeister.setPassword(encoder.encode(Password));
        n_regeister.setUsername(userName);

        assertEquals(userName,n_regeister.getUsername());
        assertSame(encoder.matches(Password,n_regeister.getPassword()), true);
    }


    /**
     *  Test for the checker RegisterFacade will return the User in the ArrayList
     */

    @Test
    @DisplayName("On Register Test")
    public void testRegisterFacadeQuery() {

        String userName = "Alice1234";
        String password ="123456";


        appUsersEntity = new AppUsersEntity();
        appUsersEntity.setUserName(userName);
        appUsersEntity.setUserPassword(password);

        ArrayList<AppUsersEntity> list = new ArrayList<>();
        list.add(appUsersEntity);

        entityManager =mock(EntityManager.class);

        RegisterFacade registerFacade = mock(RegisterFacade.class);
        when(registerFacade.checkUserName(userName)).thenReturn(list);

        list = (ArrayList<AppUsersEntity>) registerFacade.checkUserName(userName);
        verify(registerFacade,times(1)).checkUserName(userName);

        Assert.assertTrue(list.size()==1);

    }


    /***
     * Check for the on register if the user is then created by the method
     */

    @Test
    @DisplayName("On check user don't exist")
    public void testAddUser() {

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        String userName = "Alice1234";
        String password ="123456";

        String encoded = encoder.encode(password);

        AppUsersEntity appUsersEntity = mock(AppUsersEntity.class);
        appUsersEntity.setUserName(userName);
        appUsersEntity.setUserPassword(password);

        ArrayList<AppUsersEntity> list = new ArrayList<>();
        entityManager =mock(EntityManager.class);

        registerFacade = mock(RegisterFacade.class);

        when(registerFacade.checkUserName(userName)).thenReturn(list);
        Assert.assertEquals(list.size()<=0, true);

        register =mock(Register.class);

        when(register.getUsername()).thenReturn(userName);

        String name = register.getUsername();
        verify(register,times(1)).getUsername();

        Assert.assertEquals(name,userName);

        when(register.getPassword()).thenReturn(encoded);
        String registerPassword = register.getPassword();
        verify(register,times(1)).getPassword();


        Assert.assertSame(encoder.matches(password, registerPassword), true);

        when(register.onRegister()).thenReturn("index?faces-redirect=true");

        String onregister = register.onRegister();
        verify(register,times(1)).onRegister();

        Assert.assertEquals("index?faces-redirect=true", onregister);

    }

    /***
     * Check for the on register if the user  can't be created from the Register class.
     */


    @Test
    @DisplayName("Check if there already exist user")
    public void checkUserExist() {

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        String userName = "Alice1234";
        String password ="123456";

        String encoded = encoder.encode(password);

        AppUsersEntity appUsersEntity = mock(AppUsersEntity.class);
        appUsersEntity.setUserName(userName);
        appUsersEntity.setUserPassword(password);

        ArrayList<AppUsersEntity> list = new ArrayList<>();
        list.add(appUsersEntity);
        entityManager =mock(EntityManager.class);

        registerFacade = mock(RegisterFacade.class);

        when(registerFacade.checkUserName(userName)).thenReturn(list);
        list = (ArrayList<AppUsersEntity>) registerFacade.checkUserName(userName);
        verify(registerFacade,times(1)).checkUserName(userName);

        Assert.assertTrue(list.size()==1);

        register =mock(Register.class);

        register.setUsername(userName);
        when(register.getUsername()).thenReturn(userName);
        String name = register.getUsername();
        verify(register,times(1)).getUsername();

        Assert.assertEquals(name,userName);

        when(register.getPassword()).thenReturn(encoded);
        String registerPassword = register.getPassword();
        verify(register,times(1)).getPassword();

        Assert.assertSame(encoder.matches(password, registerPassword), true);

        when(register.onRegister()).thenReturn("register");
        String onregister = register.onRegister();
        verify(register,times(1)).onRegister();

        Assert.assertEquals("register", onregister);

    }

}
