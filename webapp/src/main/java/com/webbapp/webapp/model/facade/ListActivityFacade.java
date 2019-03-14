package com.webbapp.webapp.model.facade;

import com.webbapp.webapp.model.entity.ActivityEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ListActivityFacade extends ActivityFacade {
    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;

    public ListActivityFacade() {
        super();
    }

    public List<ActivityEntity> findByTypes(List<String> types) {
        TypedQuery<ActivityEntity> query = em.createNamedQuery("ActivityEntity.findByTypes", ActivityEntity.class);
        query.setParameter("types", types);
        return query.getResultList();
    }

}

