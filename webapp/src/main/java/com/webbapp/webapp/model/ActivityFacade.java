package com.webbapp.webapp.model;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Stateless
public class ActivityFacade extends AbstractFacade<ActivityEntity> {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;

    private JPAQueryFactory queryFactory;
    private QActivityEntity activity = QActivityEntity.activityEntity;

    public ActivityFacade() {
        super(ActivityEntity.class);
    }

    @PostConstruct
    public void init() {
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<ActivityEntity> findByType(String type) {
        TypedQuery<ActivityEntity> query = em.createNamedQuery("ActivityEntity.findByType", ActivityEntity.class);
        query.setParameter("type", type);
        return query.getResultList();
    }

    public List<ActivityEntity> findByCity(String city) {
        TypedQuery<ActivityEntity> query = em.createNamedQuery("ActivityEntity.findByCity", ActivityEntity.class);
        query.setParameter("city", city);
        return query.getResultList();
    }

    public List<ActivityEntity> findByTypes(List<String> types) {
        TypedQuery<ActivityEntity> query = em.createNamedQuery("ActivityEntity.findByTypes", ActivityEntity.class);
        query.setParameter("types", Stream.of("jogging").collect(Collectors.toList()));
        return query.getResultList();

        /*List<ActivityEntity> activities = queryFactory.selectFrom(activity)
                .where(activity.type.lower().in(filter
                        .stream()
                        .map(String::toLowerCase)
                        .collect(Collectors.toList())))
                .fetch();

        return activities;*/
     }
}
