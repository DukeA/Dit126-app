package com.webbapp.webapp.model.facade;

import com.webbapp.webapp.model.entity.AppUserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This class is responsible for handling interactions with the database regarding the LocationEntity class
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
