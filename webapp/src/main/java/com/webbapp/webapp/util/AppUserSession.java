package com.webbapp.webapp.util;

import com.webbapp.webapp.model.entity.AppUserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * SessionScoped bean for holding the user's session
 * once the user has successfully logged in.
 * One of the three injected beans in Login.
 */
@Named("userSession")
@SessionScoped
public class AppUserSession implements Serializable {

    @Getter @Setter
    private AppUserEntity user;
}