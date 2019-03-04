package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.ActivityEntity;
import com.webbapp.webapp.model.ActivityFacade;
import com.webbapp.webapp.model.ActivityType;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ViewScoped
public class ActivityList implements Serializable {
    private String types;

    @Inject
    ActivityFacade activityFacade;


    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        System.out.println("new types: " + types);
        this.types = types;
    }

    public List<ActivityEntity> getList() {
        System.out.println("QUERYING: " + types);
        List<ActivityEntity> activities = activityFacade.getFilteredActivities(Arrays.asList(types.split(",")));

        return activities;
    }
}