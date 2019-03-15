package dit126.controller.activity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class Type {

    public ActivityType[] getTypes() {
        return ActivityType.values();
    }
}
