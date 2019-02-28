package com.webbapp.webapp.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @ author Adam
 */
@Stateless
public class showActivityFacade extends AbstractFacade<ActivityEntity> {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private  EntityManager em;


    public showActivityFacade() {
        super(ActivityEntity.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /*public  showActivity findActivity(String title, String type){

        try{

        } catch (Exception e) {

        }
        return null;
    }*/


}
