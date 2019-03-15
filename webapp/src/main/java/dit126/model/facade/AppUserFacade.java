package dit126.model.facade;

import dit126.model.entity.AppUserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This class is responsible for handling interactions with the database regarding the AppUserEntity class
 * */
@Stateless
public class AppUserFacade extends AbstractFacade<AppUserEntity> {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;

    public AppUserFacade() {
        super(AppUserEntity.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
