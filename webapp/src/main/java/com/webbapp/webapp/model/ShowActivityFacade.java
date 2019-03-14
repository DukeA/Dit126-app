package com.webbapp.webapp.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * @author Adam Grandén
 *  This class is a Facade for taking the  values for taking
 *  the values from the showActivites and finding them in the model class
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

    /***
     * The method finds an  Activity by using the title
     * and the type of the  Activity can find what the activity is about.
     * @param title String
     * @param type String
     * @return Activity or null
     */

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

    /***
     * An method for finding the Activity by using the
     * ID of the Activity. This is done by taking the ID of the
     * activity and getting the information of it.
     * @param Id : String
     * @return Activity or null
     */

   public ActivityEntity findActivityById(String Id) {
        Query query = em.createNamedQuery("ActivityEntity.findByActivityId");
        query.setParameter("ActivityId", Id);
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
