package com.webbapp.webapp.util;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class Credentials implements Serializable {

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String password;
}
