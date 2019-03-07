package com.webbapp.webapp.controller;


//import com.webbapp.webapp.model.showActivity;

import com.webbapp.webapp.model.*;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Adam Grandén
 */

@Named(value = "showBean")
@ViewScoped
public class ShowActivitys implements Serializable {

    @Getter
    @Setter
    private ActivityEntity activityEntity;

    @Getter
    @Setter
    private Integer  activityid;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private boolean value;

    @Getter
    @Setter
    private double lat =0.0;

    @Getter
    @Setter
    private double lng =0.0;

    @Inject
    ShowActivityFacade activityFacade;

    @Inject
    LocationFacade locationFacade;


    private ActivityEntity activity;

    public String findActivityById() {
        Integer value = activityid;
        activity = activityFacade.findActivityById(String.valueOf(value));
        if(activity != null) {
            return "ShowAct?faces-redirect=true";
        } else {
            return "index";
        }
    }


    public void findBytitleActivity() {
        String value =title;
        String valueEnum = name;
        activity = activityFacade.findActivity(value, valueEnum);
        if(activity != null) {
            setValue(true);

        }
    }

    public String findbyTitleActvity() {
        String value = title;
        String valueEnum =name;
        ActivityEntity type = activityFacade.findActivity(value,valueEnum);
        setActivityEntity(type);
        if(activity !=null) {
            return "ShowAct?faces-redirect=true";
        } else {
            return "index";
        }

    }

    public String onload() {
        Integer value = activityid;
        activityEntity = activityFacade.find(value);
        if(activityEntity != null) {
            return null;
        } else {
            return "index";
        }
    }

    public String delete() {
        System.out.println("DELETING");
        LocationEntity loc = activityEntity.getLocationByLocationId();
        activityFacade.remove(activityEntity);
        locationFacade.remove(loc);
        return "index";
    }

}
