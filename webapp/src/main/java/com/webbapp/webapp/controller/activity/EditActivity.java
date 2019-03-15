package com.webbapp.webapp.controller.activity;

import com.webbapp.webapp.controller.login.AppUserSession;
import com.webbapp.webapp.model.entity.ActivityEntity;
import com.webbapp.webapp.model.facade.ActivityFacade;
import com.webbapp.webapp.model.facade.LocationFacade;
import com.webbapp.webapp.util.HttpRequest.HttpRequest;
import com.webbapp.webapp.util.HttpRequest.HttpRequestFactory;
import lombok.Getter;
import lombok.Setter;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Gustav
 * This class is the responsible controller for handling editing activities.
 */
@Named(value="editActivity")
@ViewScoped
public class EditActivity implements Serializable {

    @Inject
    ActivityFacade activityFacade;

    @Inject
    LocationFacade locationFacade;

    @Inject
    AppUserSession userSession;

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

    private ActivityEntity current;

    /**
     * Adds a new activity to the activity facade
     * Uses the lat, lng, title, type, description instance variables as input for the activity and location
     * */
    public void edit(){

        //Do the editing
        if(isOwner() && current != null && title != null && description != null && type != null && lat != null && lng != null) {
            try{
                current.setTitle(title);
                current.setType(type.name());

                current.getLocationByLocationId().setLongitude(Double.parseDouble(lng));
                current.getLocationByLocationId().setLatitude(Double.parseDouble(lat));


                HttpRequest req = HttpRequestFactory.getHttpRequest();
                String city = req.getCity(Double.parseDouble(lat), Double.parseDouble(lng));
                //Save the changes

                current.getLocationByLocationId().setCity(city.toLowerCase());

                locationFacade.edit(current.getLocationByLocationId());
                activityFacade.edit(current);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Initial setup when page is loaded
     * */
    public String onLoad() {
        current = activityFacade.find(Integer.parseInt(id));
        if(isOwner()){
            title = current.getTitle();
            lat = current.getLocationByLocationId().getLatitude()+"";
            lng = current.getLocationByLocationId().getLongitude()+"";
            description = current.getDescription();
            type = ActivityType.valueOf(current.getType());
            return null;
        } else{
            return "index.xhtml";
        }
    }

    private boolean isOwner(){
        return current != null && userSession.getUser() != null && current.getAppUsersByUserId().equals(userSession.getUser());
    }
}