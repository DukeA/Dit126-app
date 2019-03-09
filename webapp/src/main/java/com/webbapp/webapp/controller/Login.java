/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webbapp.webapp.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.webbapp.webapp.model.AppUsersEntity;
import com.webbapp.webapp.model.UsersFacade;
import lombok.Getter;

/**
 *
 * @author gustav
 */
@Named(value="login")
@SessionScoped
public class Login implements Serializable{
    
    private String username;
    
    private String password;
    
    @Inject
    UsersFacade userManager;

    @Getter
    private AppUsersEntity user;
    
    public String login(){
        user = userManager.findUser(username, password);
        if(user != null){
            return "index";
        }else{
            return "index";
        }
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
    
    public String getUserName(){
        return username;
    }
    
    public String getPassword(){
        return username;
    }
    
    public void setUserName(String name){
        username = name;
    }
    
    public void setPassword(String pass){
        password = pass;
    }
}
