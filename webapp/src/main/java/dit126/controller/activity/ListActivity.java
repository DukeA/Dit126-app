package dit126.controller.activity;

import dit126.model.entity.ActivityEntity;
import dit126.model.facade.ListActivityFacade;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * This class is responsible for handling request to list activities
 */
@Named
@ViewScoped
public class ListActivity implements Serializable {
    // Comma separated string containing types
    @Getter
    @Setter
    private String types;

    @Inject
    ListActivityFacade activityFacade;

    @PostConstruct
    public void init(){
        types = "";
    }

    /**
     *
     * @return a list containing activities with types contained in getTypes()
     */
    public List<ActivityEntity> getList() {
        return activityFacade.findByTypes(Arrays.asList(types.split(",")));
    }
}