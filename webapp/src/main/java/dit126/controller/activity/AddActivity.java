package dit126.controller.activity;

import dit126.controller.login.AppUserSession;
import dit126.model.entity.ActivityEntity;
import dit126.model.entity.LocationEntity;
import dit126.model.facade.ActivityFacade;
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
 * This class is the responsible controller for handling adding new activities to the database.
 */
@Named(value="addActivity")
@ViewScoped
public class AddActivity implements Serializable {

    @Inject
    ActivityFacade activityFacade;

    @Inject
    AppUserSession userSession;

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
    public String add(){
        if(userSession.getUser() != null && title != null && description != null && type != null && lat != null && lng != null){

            try{
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

                    activity.setAppUsersByUserId(userSession.getUser());
                    activity.setLocationByLocationId(loc);

                    activityFacade.create(activity);
                    return "showAct?id="+ activity.getActivityId() +"&faces-redirect=true";
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }


        }
        
        return null;
    }

    /**
     * Initial setup when page is loaded
     * */
    public String onLoad() {
        if(userSession.getUser() != null){
            return null;
        } else{
            return "index.xhtml";
        }
    }
}