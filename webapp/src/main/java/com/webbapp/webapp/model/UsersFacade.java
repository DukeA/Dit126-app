/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webbapp.webapp.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author gustav
 */
@Stateless
public class UsersFacade extends AbstractFacade<AppUsersEntity> {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(AppUsersEntity.class);
    }
    
    public AppUsersEntity findUser(String username, String password){
        Query q = em.createNamedQuery("app_user.login");
        q.setParameter("userName", username);
        q.setParameter("userPassword", password);
        
        try{
            AppUsersEntity u = (AppUsersEntity)q.getSingleResult();
            System.out.println("User found");
            return u;
        }catch(Exception e){
            System.out.println(e);
            System.out.println("User not found");
            return null;
        }
    }
    
}
