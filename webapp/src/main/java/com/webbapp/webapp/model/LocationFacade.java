package com.webbapp.webapp.model;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class LocationFacade extends AbstractFacade<LocationEntity> {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;

    public LocationFacade() {
        super(LocationEntity.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
