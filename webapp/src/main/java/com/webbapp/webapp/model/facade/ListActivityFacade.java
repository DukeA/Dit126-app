package com.webbapp.webapp.model.facade;

import com.webbapp.webapp.model.entity.ActivityEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ListActivityFacade {

    @Inject
    private ActivityFacade activityFacade;

    public List<ActivityEntity> findByTypes(List<String> types) {
        TypedQuery<ActivityEntity> query = activityFacade.getEntityManager().createNamedQuery("ActivityEntity.findByTypes", ActivityEntity.class);
        query.setParameter("types", types);
        return query.getResultList();
    }

}

