package com.webbapp.webapp.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
   public ActivityEntity findActivityById(String integerId) {
        Query query = em.createNamedQuery("ActivityEntity.findByActivityId");
        query.setParameter("ActivityId", integerId);
        try {
            ActivityEntity activityEntity = (ActivityEntity) query.getSingleResult();
            System.out.println("Activity Found");
            return  activityEntity;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Activity not found");
            return null;
        }
   }


}
