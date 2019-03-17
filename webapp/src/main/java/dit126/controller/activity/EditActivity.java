package dit126.controller.activity;

import dit126.controller.login.AppUserSession;
import dit126.model.entity.ActivityEntity;
import dit126.model.facade.ActivityFacade;
import dit126.model.facade.LocationFacade;
import dit126.util.HttpRequest.HttpRequest;
import dit126.util.HttpRequest.HttpRequestFactory;
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
    public String edit(){

        //Do the editing
        if(isOwner() && current != null && title != null && description != null && type != null && lat != null && lng != null) {
            try{
                current.setTitle(title);
                current.setType(type.name());
                current.setDescription(description);

                current.getLocationByLocationId().setLongitude(Double.parseDouble(lng));
                current.getLocationByLocationId().setLatitude(Double.parseDouble(lat));


                HttpRequest req = HttpRequestFactory.getHttpRequest();
                String city = req.getCity(Double.parseDouble(lat), Double.parseDouble(lng));
                //Save the changes

                current.getLocationByLocationId().setCity(city.toLowerCase());

                locationFacade.edit(current.getLocationByLocationId());
                activityFacade.edit(current);

                return "showAct?id="+ current.getActivityId() +"&faces-redirect=true";
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        return null;
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