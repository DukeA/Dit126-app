package com.webbapp.webapp.model.facade;

import com.webbapp.webapp.model.entity.ActivityEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
