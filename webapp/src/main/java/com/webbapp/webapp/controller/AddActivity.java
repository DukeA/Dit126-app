package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.*;
import com.webbapp.webapp.util.HttpRequest;
import com.webbapp.webapp.util.HttpRequestFactory;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named(value="addActivity")
@SessionScoped
public class AddActivity implements Serializable {

    @Inject
    AddActivityFacade activityFacade;

    @Inject
    UsersFacade usersFacade;

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

    public void add(){
        ActivityEntity activity = new ActivityEntity();
        activity.setTitle(title);
        activity.setActivityId(title); //Auto genereras
        activity.setDescription(description);
        activity.setActivity(ActivityType.TYPE1.name());

        HttpRequest req = HttpRequestFactory.getHttpRequest();
        String city = req.getCity(Double.parseDouble(lat), Double.parseDouble(lng));

        LocationEntity loc = new LocationEntity();
        loc.setLatitude(Double.parseDouble(lat));
        loc.setLongitude(Double.parseDouble(lng));
        loc.setCity(city);

        activity.setAppUsersByUserId(usersFacade.findAll().get(0));
        activity.setLocationByLocationId(loc);

        System.out.println(activity);
        System.out.println(loc);

        activityFacade.create(activity);
    }
}