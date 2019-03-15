package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.entity.AppUserEntity;
import com.webbapp.webapp.model.facade.RegisterFacade;
import com.webbapp.webapp.util.AppUserSession;
import com.webbapp.webapp.util.exception.MultipleUsersFoundException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;



/***
 * @author Adam Grandén
 *
 * The controller class for register which would be able to
 * return a  new user from the input fields.
 */


@Named(value = "register")
@RequestScoped
public class Register implements Serializable {

    private String username;

    private String password;

    @Inject
    RegisterFacade registerFacade;

    @Inject
    private AppUserSession userSession;

    @Getter
    @Setter
    private UIComponent registerButton;

    /***
     * @author Adam Grandén
     *  The parameters are  returned from the input fields on the web page.
     *  It is checked if a user already exists in the database by checking the
     *  username in the database. If the Username exist then the new user would not be created.
     * @return String for the new web page.
     */

    public String register()  {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        AppUserEntity appUsersEntity = new AppUserEntity();
        if (username == null || username.equals("")) {
            this.addErrorMessage("Username can't be empty");
            return "register";
        }
        appUsersEntity.setUserName(username);
        if (password == null || password.equals("")) {
            this.addErrorMessage("Username password can't be empty");
            return "register";
        }
        appUsersEntity.setUserPassword(encoder.encode(password));
        try {
            registerFacade.checkUserName(username);
            registerFacade.create(appUsersEntity);
            return "index";
        } catch (MultipleUsersFoundException e) {
            this.addErrorMessage("Found multiple users with the same name");
            return "register";
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    /***
     *   A Method to load the User value from the User if
     *   the user could not be found then it would be set to  null,
     *   if not then the value would be of index
     * @return String Website index
     */
    public String onLoad() {
        if (userSession.getUser() != null) {
            return "index";
        } else {
            return null;
        }
    }

    /***
     * The method is used for if there is an error
     * with register the user if there is a multiple Users with the same name
     * @param message
     */
    public void addErrorMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(registerButton.getClientId(context),
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }
}
