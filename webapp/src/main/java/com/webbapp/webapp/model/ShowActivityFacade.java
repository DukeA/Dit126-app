package com.webbapp.webapp.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @ author Adam
 */
@Stateless
public class ShowActivityFacade extends AbstractFacade<ActivityEntity> {

    @PersistenceContext(unitName = "NewPersistenceUnit")
    private  EntityManager em;


    public ShowActivityFacade() {
        super(ActivityEntity.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public  ActivityEntity findActivity(String title, String type){
        Query q  = em.createNamedQuery("activity.getActivity");
        q.setParameter("title", title);
        q.setParameter("type", type);
        try{
            ActivityEntity activityEntity =(ActivityEntity) q.getSingleResult();
            System.out.println("Activity found");
            return  activityEntity;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Activity not found");
            return null;
        }
    }
    /*
    public ActivityEntity findByTitle(String title) {
        Query q = em.createNamedQuery("activity.findtitle");
        q.setParameter("title", title);
        try {
            ActivityEntity activityEntity = (ActivityEntity) q.getResultList();
            System.out.println("Found all the Activites");
            return  activityEntity;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Activites not Found");
            return  null;
        }
    }
    public ActivityEntity findBytypeAll(String type) {
        Query q = em.createNamedQuery("activity.findactivity");
        q.setParameter("activity", type);
        try {
            ActivityEntity activityEntity = (ActivityEntity) q.getResultList();
            System.out.println("Found all the Activites");
            return  activityEntity;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Activites not Found");
            return  null;
        }
    }
    @Override
    public List<ActivityEntity> findAll() {
        Query q  = em.createNamedQuery("activity.find_all");
        try {
            List<ActivityEntity> List = new ArrayList<>();
            List.add ((ActivityEntity) q.getResultList());
            System.out.println("Found all the Activites");
            return  List;
        }catch (Exception e) {
            System.out.println(e);
            System.out.println("Activites not Found");
            return  null;
        }
    }
    */


}
