package com.webbapp.webapp.model;

import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<ActivityEntity> getFilteredActivities(String[] filter) {
        List<ActivityEntity> activities = queryFactory.selectFrom(activity)
                .where(activity.activity.lower().in(Arrays
                                .stream(filter)
                                .map(item -> item.toLowerCase())
                                .collect(Collectors.toList())))
                .fetch();

        return activities;
     }
}
