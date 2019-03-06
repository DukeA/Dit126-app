package com.webbapp.webapp.model;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class RegisterFacade extends AbstractFacade<AppUsersEntity> {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public RegisterFacade() {
        super(AppUsersEntity.class);
    }
}
