package com.webbapp.webapp.model.facade;

import com.webbapp.webapp.model.entity.ActivityEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class SearchFacade {

    @Inject
    private ActivityFacade activityFacade;

    public List<ActivityEntity> findByType(String type) {
        TypedQuery<ActivityEntity> query = activityFacade.getEntityManager().createNamedQuery("ActivityEntity.findByType", ActivityEntity.class);
        query.setParameter("type", type);
        return query.getResultList();
    }

    public List<ActivityEntity> findByCity(String city) {
        TypedQuery<ActivityEntity> query = activityFacade.getEntityManager().createNamedQuery("ActivityEntity.findByCity", ActivityEntity.class);
        query.setParameter("city", city);
        return query.getResultList();
    }
}
