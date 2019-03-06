package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.AppUsersEntity;
import com.webbapp.webapp.model.RegisterFacade;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("Register")
public class Register implements Serializable {

    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    private String password;

    @Inject
    RegisterFacade registerFacade;

    private AppUsersEntity appUsersEntity;

    public String register() {
        appUsersEntity = new AppUsersEntity();
        appUsersEntity.setUserName(username);
        appUsersEntity.setUserPassword(password);
        registerFacade.create(appUsersEntity);
        if(appUsersEntity != null) {
            return"Register?faces-redirect=true";
        } else{
            return "list";
        }

    }




}
