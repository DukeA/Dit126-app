package com.webbapp.webapp.model;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

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

    public List<AppUsersEntity> checkUserName(String userName) {
        Query query = em.createNamedQuery("app_users.checkUserName", AppUsersEntity.class);
        query.setParameter("userName",userName);
        return query.getResultList();
    }



}
