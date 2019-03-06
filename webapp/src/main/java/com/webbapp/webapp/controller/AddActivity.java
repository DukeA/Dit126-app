package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.*;
import com.webbapp.webapp.util.HttpRequest;
import com.webbapp.webapp.util.HttpRequestFactory;
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
    AppUserFacade usersFacade;

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
        ActivityEntity activity = new ActivityEntity();
        activity.setTitle(title);
        activity.setDescription(description);
        activity.setType(ActivityType.TYPE1.name());

        HttpRequest req = HttpRequestFactory.getHttpRequest();
        String city = req.getCity(Double.parseDouble(lat), Double.parseDouble(lng));


        LocationEntity loc = new LocationEntity();
        loc.setLatitude(Double.parseDouble(lat));
        loc.setLongitude(Double.parseDouble(lng));
        loc.setCity(city.toLowerCase());

        activity.setAppUsersByUserId(usersFacade.findAll().get(0));
        activity.setLocationByLocationId(loc);

        activityFacade.create(activity);
    }
}