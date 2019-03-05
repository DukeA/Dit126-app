package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.*;
import com.webbapp.webapp.util.HttpRequest;
import com.webbapp.webapp.util.HttpRequestFactory;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named(value="editActivity")
@ViewScoped
/**
 * @author Gustav
 * This class is the responsible controller for handling editing activities.
 */
public class EditActivity implements Serializable {

    @Inject
    AddActivityFacade activityFacade;

    @Inject
    UsersFacade usersFacade;

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String lat;

    @Getter
    @Setter
    private String lng;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private ActivityType type;

    @PostConstruct
    public void init(){
        //TODO: get all the values so that the interface can show what we already have
    }

    /**
     * Adds a new activity to the activity facade
     * Uses the lat, lng, title, type, description instance variables as input for the activity and location
     * */
    public void edit(){

        System.out.println("This guy =>" + id);
        //TODO: check so that its really the owner of the post who is trying to edit it

        //Get the activity
        //ActivityEntity act = activityFacade.find();

        //Do the editing
        HttpRequest req = HttpRequestFactory.getHttpRequest();
        String city = req.getCity(Double.parseDouble(lat), Double.parseDouble(lng));

        //Save the changes

        //activityFacade.edit(activity);
    }
}