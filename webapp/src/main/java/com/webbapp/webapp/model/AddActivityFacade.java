package com.webbapp.webapp.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AddActivityFacade extends AbstractFacade<ActivityEntity> {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AddActivityFacade() {
        super(ActivityEntity.class);
    }

}