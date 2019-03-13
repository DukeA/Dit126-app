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
import com.webbapp.webapp.util.exception.*;
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

        try {
           userSession.setUser(userFacade.login(username, password));
        }
        catch (UserNotFoundException e) {
            this.addErrorMessage("User not found");
        }
        catch (MultipleUsersFoundException e) {
            this.addErrorMessage("Found multiple users with the same name");
        }
        catch (IncorrectPasswordException e) {
            this.addErrorMessage("Incorrect password");
        }

        return this.onLoad();
    }

    /**
     * Adds an error message to login.xhtml depending on  Exception was caught
     * during a failed login.
     */
    public void addErrorMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(loginButton.getClientId(context),
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
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
