package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.ActivityEntity;
import com.webbapp.webapp.model.AddActivityFacade;
import com.webbapp.webapp.model.LocationEntity;
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

    public void add(){
        ActivityEntity activity = new ActivityEntity();
        activity.setTitle("Cycling spot");

        activity.setDescription("Lorem ipsum");
        activity.setActivity("Cycling");

        HttpRequest req = HttpRequestFactory.getHttpRequest();
        String city = req.getCity(Double.parseDouble(lat), Double.parseDouble(lng));

        LocationEntity loc = new LocationEntity();
        loc.setLatitude(Double.parseDouble(lat));
        loc.setLongitude(Double.parseDouble(lng));
        loc.setCity(city);

        System.out.println(activity);
        System.out.println(loc);


    }
}