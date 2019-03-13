package com.webbapp.webapp.util;

import com.webbapp.webapp.model.AppUserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("userSession")
@SessionScoped
public class AppUserSession implements Serializable {

    @Getter @Setter
    private AppUserEntity user;
}