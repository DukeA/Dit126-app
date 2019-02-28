package com.webbapp.webapp.model;

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
    protected EntityManager getEntityManager() {
        return em;
    }
}
