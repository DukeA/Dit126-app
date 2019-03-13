/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webbapp.webapp.controller;

import java.io.Serializable;
import javax.ejb.EJBException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.webbapp.webapp.model.AppUserFacade;
import com.webbapp.webapp.util.*;

@Named(value="login")
@RequestScoped
public class Login implements Serializable {

    @Inject
    private Credentials credentials;

    @Inject
    private AppUserFacade userFacade;

    @Inject
    private AppUserSession userSession;

    public void login() {

        String username = credentials.getUsername();
        String password = credentials.getPassword();

        try {
           userSession.setUser(userFacade.login(username, password));
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
        } catch (EJBException e) {
            //perhaps should be avoided
        }
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }

}
