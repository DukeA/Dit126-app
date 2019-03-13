package com.webbapp.webapp.controller;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.webbapp.webapp.model.AppUserFacade;
import com.webbapp.webapp.util.*;
import lombok.Getter;
import lombok.Setter;

/**
 * RequestScoped bean that requires three other beans to perform
 * a successful login.
 */
@Named(value="login")
@RequestScoped
public class Login implements Serializable {

    @Inject
    private Credentials credentials;

    @Inject
    private AppUserFacade userFacade;

    @Inject
    private AppUserSession userSession;

    @Getter @Setter
    private UIComponent loginButton;

    public String login() {

        String username = credentials.getUsername();
        String password = credentials.getPassword();

        FacesContext context = FacesContext.getCurrentInstance();

        try {
           userSession.setUser(userFacade.login(username, password));
        } catch (UserNotFoundException e) {
            String message = "User not found";
            context.addMessage(loginButton.getClientId(context),
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        } catch (MultipleUsersFoundException e) {
            String message = "Found multiple users with the same name";
            context.addMessage(loginButton.getClientId(context),
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        } catch (IncorrectPasswordException e) {
            String message = "Incorrect password";
            context.addMessage(loginButton.getClientId(context),
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
        }

        if (userSession.getUser() != null) {
            return "index";
        } else {
            return null;
        }
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }

    public String onLoad() {
        if (userSession.getUser() != null) {
            return "index";
        } else {
            return null;
        }
    }

}
