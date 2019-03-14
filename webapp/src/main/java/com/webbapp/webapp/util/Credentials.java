package com.webbapp.webapp.util;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * RequestScoped bean that holds the user's credentials for performing
 * a login to the system.
 * One of the three beans injected in Login.
 */
@Named
@RequestScoped
public class Credentials implements Serializable {

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String password;
}
