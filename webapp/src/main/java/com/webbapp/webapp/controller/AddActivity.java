package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.*;
import com.webbapp.webapp.util.HttpRequest.HttpRequest;
import com.webbapp.webapp.util.HttpRequest.HttpRequestFactory;
import lombok.Getter;
import lombok.Setter;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named(value="addActivity")
@ViewScoped
/**
 * @author Gustav
 * This class is the responsible controller for handling adding new activities to the database.
 */
public class AddActivity implements Serializable {

    @Inject
    AddActivityFacade activityFacade;

    @Inject
    Login login;

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

    /**
     * Adds a new activity to the activity facade
     * Uses the lat, lng, title, type, description instance variables as input for the activity and location
     * */
    public void add(){
        if(title != null && description != null && type != null && lat != null && lng != null){
            ActivityEntity activity = new ActivityEntity();
            activity.setTitle(title);
            activity.setDescription(description);
            activity.setType(type.name());

            HttpRequest req = HttpRequestFactory.getHttpRequest();
            String city = req.getCity(Double.parseDouble(lat), Double.parseDouble(lng));
            if(city != null){
                LocationEntity loc = new LocationEntity();
                loc.setLatitude(Double.parseDouble(lat));
                loc.setLongitude(Double.parseDouble(lng));
                loc.setCity(city.toLowerCase());

                activity.setAppUsersByUserId(login.getUser());
                activity.setLocationByLocationId(loc);

                activityFacade.create(activity);
            }
        }
    }

    public String onLoad() {
        if(login.getUser() != null){
            return null;
        } else{
            return "index.xhtml";
        }
    }
}