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
import com.webbapp.webapp.model.Users;
import com.webbapp.webapp.model.UsersFacade;

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
    
    private Users user;
    
    public String login(){
        user = userManager.findUser(username, password);
        if(user != null){
            return "list?faces-redirect=true";
        }else{
            return "index";
        }
    }
    
    public String newHome(){
        System.out.println("Set new home!");
        userManager.edit(user);
        return "list";
    }
    
    public void setLat(String d){
        user.setLat(Double.parseDouble(d));
    }
    
    public void setLng(String d){
        user.setLng(Double.parseDouble(d));
    }
    
    public String getLng(){
        return ""+user.getLng();
    }
    
    public String getLat(){
        return ""+user.getLat();
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
