/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webbapp.webapp.controller;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.webbapp.webapp.model.AppUserEntity;
import com.webbapp.webapp.model.AppUserFacade;
import com.webbapp.webapp.util.IncorrectPasswordException;
import com.webbapp.webapp.util.MultipleUsersFoundException;
import com.webbapp.webapp.util.UserNotFoundException;
import lombok.Getter;
import lombok.Setter;

@Named(value="login")
@RequestScoped
public class Login implements Serializable{

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String password;

    @EJB
    private AppUserFacade userManager;
    
    private AppUserEntity user;
    
    public void login() {

        try {
            user = userManager.login(username, password);
        } catch (UserNotFoundException e) {
            String message = "User not found";
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        } catch (MultipleUsersFoundException e) {
            String message = "Found multiple users with the same name";
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        } catch (IncorrectPasswordException e){
            String message = "Incorrect password";
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        }
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }

}
