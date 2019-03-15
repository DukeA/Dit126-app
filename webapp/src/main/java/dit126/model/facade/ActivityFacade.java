package dit126.model.facade;

import dit126.model.entity.ActivityEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This class is responsible for handling interactions with the database regarding the ActivityEntity class
 * */
@Stateless
public class ActivityFacade extends AbstractFacade<ActivityEntity> {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;


    public ActivityFacade() {
        super(ActivityEntity.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
