package dit126.model.facade;


import dit126.model.entity.AppUserEntity;
import dit126.util.exception.MultipleUsersFoundException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * @author Adan Grandén
 *  The facade Model class for register to get the  information
 *  from the model class to get information from the Database
 *
 */
@Stateless
public class RegisterFacade {

    @Inject
    private AppUserFacade userFacade;

    /***
     *  The Query to get all the information from the database where
     *  the  userName equals the username and return that to the controller
     * @param userName String value of the username
     */
    public void checkUserName(String userName) throws MultipleUsersFoundException {
        List<AppUserEntity> valueList = userFacade.getEntityManager().createNamedQuery("app_user.register", AppUserEntity.class).
                setParameter("userName",userName).getResultList();
        if (valueList.size()>0) {
            throw  new MultipleUsersFoundException();
        }
    }

    public void create(AppUserEntity user) {
        userFacade.create(user);
    }

}
