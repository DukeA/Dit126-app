package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.ActivityType;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Type {

    public ActivityType[] getTypes() {
        return ActivityType.values();
    }
}
