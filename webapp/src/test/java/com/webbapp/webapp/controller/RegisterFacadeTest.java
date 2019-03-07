package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.AppUsersEntity;
import com.webbapp.webapp.model.RegisterFacade;
import javafx.beans.binding.When;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(JUnit4.class)
public class RegisterFacadeTest {

    @InjectMocks
    private Register register;

    @Mock
    private RegisterFacade registerFacade;


    @BeforeClass
    public static  void setup() {
        RegisterFacadeTest registerFacadeTest = new RegisterFacadeTest();
        MockitoAnnotations.initMocks(registerFacadeTest);
    }

    @Test
    @DisplayName("Check Set and getters")
    public void testAddUserGetterAndSetter(){
        register = new Register();
        String userName = "Alice1234";
        String Password = "123456";
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        AppUsersEntity usersEntity = new AppUsersEntity();
        usersEntity.setUserName(userName);
        usersEntity.setUserPassword(Password);

        register.setPassword(Password);
        register.setUsername(userName);

        assertEquals(userName,register.getUsername());
        assertEquals(Password,register.getPassword());
    }
    @Test
    @DisplayName("On Register Test")
    public void testAddUser() {
        register =new Register();
        registerFacade = new RegisterFacade();
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        String userName = "Motorway1468";
        String password ="123456";

        register.setUsername(userName);
        register.setPassword(password);

        ArrayList<AppUsersEntity> list = new ArrayList<>();

        when(register.onRegister()).thenReturn("index?faces-redirect=true");

        Assert.assertEquals(userName,register.getUsername());
        Assert.assertEquals(password,register.getPassword());

    }
    @Test
    @DisplayName("Check if there already exist user")
    public void checkUserExist() {
        register = new Register();
        registerFacade = new RegisterFacade();
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String username ="DUKEA";
        String password ="123456";

        AppUsersEntity appUsersEntity = new AppUsersEntity();
        appUsersEntity.setUserName(username);
        appUsersEntity.setUserPassword(password);
        

        register.setPassword(password);
        register.setUsername(username);

        when(register.onRegister()).thenReturn("register");

        Assert.assertEquals(username,register.getUsername());
        Assert.assertEquals(password,register.getPassword());
    }

}
