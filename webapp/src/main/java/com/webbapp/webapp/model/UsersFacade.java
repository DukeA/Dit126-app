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
public class UsersFacade extends AbstractFacade<Users> {

    @PersistenceContext(unitName = "projectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsersFacade() {
        super(Users.class);
    }
    
    public Users findUser(String username, String password){
        Query q = em.createNamedQuery("Users.login");
        q.setParameter("username", username);
        q.setParameter("password", password);
        
        try{
            Users u = (Users)q.getSingleResult();
            System.out.println("User found");
            return u;
        }catch(Exception e){
            System.out.println(e);
            System.out.println("User not found");
            return null;
        }
    }
    
}
