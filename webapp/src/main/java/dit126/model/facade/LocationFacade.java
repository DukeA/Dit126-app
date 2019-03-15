package dit126.model.facade;

import dit126.model.entity.LocationEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This class is responsible for handling interactions with the database regarding the LocationEntity class
 * */
@Stateless
public class LocationFacade extends AbstractFacade<LocationEntity> {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;

    public LocationFacade() {
        super(LocationEntity.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
