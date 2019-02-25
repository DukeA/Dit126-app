package com.webbapp.webapp.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @ author Adam
 */
@Stateless
public class showActivityFacade extends AbstractFacade {

    @PersistenceContext(unitName = "projectPU")
    private  EntityManager em;

    public showActivityFacade(){
        super(showActivity.class);
    }

    public showActivityFacade(Class entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return null;
    }
    public  showActivity findActivity(String title, String type){
        Query query = em.createQuery("");

        try{

        } catch (Exception e) {

        }
    }


}
