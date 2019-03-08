package com.webbapp.webapp.model;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author: Adan Grandén
 *  The Facade Model class for register to get the  information
 *  from the model class to get information from the Database
 *
 */



@Stateless
public class RegisterFacade extends AbstractFacade<AppUsersEntity> {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;

    private Query query;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public RegisterFacade() {
        super(AppUsersEntity.class);
    }

    /***
     *  The Query to get all the information from the database where
     *  the  userName equals the username and return that to the controller
     * @param userName
     * @return List<AppUsersEntity>
     */
    public List<AppUsersEntity> checkUserName(String userName) {
        return em.createQuery("app_users.register", AppUsersEntity.class).
                setParameter("userName",userName).getResultList();
    }

}
