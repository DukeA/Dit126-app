package dit126.controller.activity;



import dit126.controller.login.AppUserSession;
import dit126.model.entity.ActivityEntity;
import dit126.model.entity.LocationEntity;
import dit126.model.facade.ActivityFacade;
import dit126.model.facade.LocationFacade;
import lombok.Getter;
import lombok.Setter;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Adam Grandén
 *  The class is resbonsible for the  showing an more detail
 *  version of the activity, this is done by taking the activity id
 *  and getting the infromation  from the model class.
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
    ActivityFacade activityFacade;

    @Inject
    LocationFacade locationFacade;

    @Inject
    AppUserSession userSession;



    public String onload() {
        Integer value = activityid;
        activityEntity = activityFacade.find(value);
        if(activityEntity != null) {
            return null;
        } else {
            return "index?faces-redirect=true";
        }
    }

    public String delete() {
        if (isOwnActivity()) {
            LocationEntity loc = activityEntity.getLocationByLocationId();
            activityFacade.remove(activityEntity);
            locationFacade.remove(loc);
            return "index?faces-redirect=true";
        }
        return null;
    }

    public boolean isOwnActivity() {
        return activityEntity != null && userSession.getUser() != null && activityEntity.getAppUsersByUserId().equals(userSession.getUser());
    }

}
