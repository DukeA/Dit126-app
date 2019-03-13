package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.AppUserEntity;
import com.webbapp.webapp.model.RegisterFacade;
import com.webbapp.webapp.util.AppUserSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


/***
 * @author  Adam Grandén
 *
 * The controller class for register which would be able to
 * return a  new user from the input fields.
 */


@Named("register")
@RequestScoped
public class Register implements Serializable {

    private String username;

    private String password;

    @Inject
    RegisterFacade registerFacade;

    @Inject
    private AppUserSession userSession;

    private AppUserEntity appUsersEntity;

    /***
     *  The parameters are  returned from the input fields on the webbpage.
     *  It is checked if a user already exists in the database by checking the
     *  username in the database. If the Username exist then the new user would not be created.
     * @param  username, password
     * @return String for the new webpage.
     */

    public String onRegister() {
        List<AppUserEntity> list = registerFacade.checkUserName(username);
        if(list.size() <= 0) {
            System.out.println("Create User");
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            appUsersEntity = new AppUserEntity();
            appUsersEntity.setUserName(username);
            appUsersEntity.setUserPassword(encoder.encode(password));
            registerFacade.create(appUsersEntity);
            return "login?faces-redirect=true";
        } else {
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

    public String onLoad() {
        if (userSession.getUser() != null) {
            return "index";
        } else {
            return null;
        }
    }
}
