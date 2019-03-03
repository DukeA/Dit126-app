package com.webbapp.webapp.controller;


//import com.webbapp.webapp.model.showActivity;

import com.webbapp.webapp.model.ActivityEntity;
import com.webbapp.webapp.model.ActivityType;
import com.webbapp.webapp.model.ShowActivityFacade;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Adam Grandén
 */

@Named(value = "showBean")
@RequestScoped
public class ShowActivitys implements Serializable {


    private String title;

    private String description;

    private String name;

    private boolean value;

    private double lat =0.0;

    private double lng =0.0;

    @Inject
    ShowActivityFacade activityFacade;


    private ActivityEntity activity;

    public String findByTitleActivity() {
        String value =title;
        String valueEnum = name;
        activity = activityFacade.findActivity(value, valueEnum);
        if(activity != null) {
            setValue(true);
            setLat(activity.getLocationByLocationId().getLatitude());
            setLat(activity.getLocationByLocationId().getLongitude());
            return "Found";
        } else {
            return "Not Found";
        }
    }

    public String findbyTitleActvity() {
        String value = title;
        String valueEnum =name;
        ActivityEntity type = activityFacade.findActivity(value,valueEnum);
        setActivity(type);
        if(activity !=null) {
            return "ShowAct?faces-redirect=true";
        } else {
            return "index";
        }

    }


    public void setType(String typeEnum) {
        this.name =typeEnum;
    }
    public  String  getType() {
        return this.name;
    }

    public ActivityType[] getTypes() {
        return ActivityType.values();
    }

    public String getDescription() {
        return description;
    }
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ActivityEntity getActivity() {
        return activity;
    }

    public void setActivity(ActivityEntity activity) {
        this.activity = activity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setValue(boolean value) {
        this.value =value;
    }
    public boolean getValue() {
        return this.value;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }
}
