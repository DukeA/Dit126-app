package com.webbapp.webapp.model.facade;


import com.webbapp.webapp.model.entity.AppUserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Adan Grandén
 *  The facade Model class for register to get the  information
 *  from the model class to get information from the Database
 *
 */
@Stateless
public class RegisterFacade extends AppUserFacade {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;

    public RegisterFacade() {
        super();
    }

    /***
     *  The Query to get all the information from the database where
     *  the  userName equals the username and return that to the controller
     * @param userName String value of the username
     * @return List<AppUsersEntity>
     */
    public List<AppUserEntity> checkUserName(String userName) {
        return em.createNamedQuery("app_user.register", AppUserEntity.class).
                setParameter("userName",userName).getResultList();
    }

}
