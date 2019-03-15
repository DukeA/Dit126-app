package dit126.model.facade;

import dit126.model.entity.ActivityEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ListActivityFacade {

    @Inject
    private ActivityFacade activityFacade;

    /**
     *
     * @param types List of strings (types)
     * @return List of ActivityEntity where each ActivityEntity has a type corresponding to a type in types
     */
    public List<ActivityEntity> findByTypes(List<String> types) {
        TypedQuery<ActivityEntity> query = activityFacade.getEntityManager().createNamedQuery("ActivityEntity.findByTypes", ActivityEntity.class);
        query.setParameter("types", types);
        return query.getResultList();
    }

}

