package dit126.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/***
 * The class is an representation of the value for the AppUsersEntity
 * in the database. This would be the entity of an User in the program.
 */

@Entity
@NamedQueries({
        @NamedQuery(name="app_user.findall", query = "SELECT u FROM AppUserEntity u ")
        ,@NamedQuery(name="app_user.findUserId", query = "SELECT u FROM AppUserEntity u WHERE u.userId = :userId")
        ,@NamedQuery( name="app_user.findUsername", query ="SELECT u FROM  AppUserEntity u WHERE u.userName = :userName" )
        ,@NamedQuery(name="app_user.finduserPassword", query ="SELECT u FROM  AppUserEntity  u WHERE u.userPassword = :userPassword")
        ,@NamedQuery(name="app_user.login",query = "SELECT u FROM AppUserEntity u WHERE u.userName = :userName AND u.userPassword = :userPassword")
        ,@NamedQuery(name="app_user.register" ,query = "SELECT u from AppUserEntity  u WHERE  u.userName = :userName")
})
@Table(name = "app_user", schema = "public", catalog = "dit126")
public class AppUserEntity {
    @Id
    @SequenceGenerator(name="app_user_user_id_seq", sequenceName="app_user_user_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="app_user_user_id_seq")
    @NotNull
    @Column(name = "user_id", updatable=false)
    private Integer userId;

    @Basic
    @Column(name = "user_password")
    @Getter
    @Setter
    private String userPassword;

    @Basic
    @Column(name = "user_name")
    @Getter
    @Setter
    private String userName;

    @OneToMany(mappedBy = "appUsersByUserId")
    @Getter
    @Setter
    private Collection<ActivityEntity> activitiesByUserId;


    /***
     * The equals method iis for checking if two other class
     * would be the same method in this case.
     * @param o another entity
     * @return boolean value
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppUserEntity that = (AppUserEntity) o;

        if (userId != that.userId) return false;
        if (userPassword != null ? !userPassword.equals(that.userPassword) : that.userPassword != null) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;

        return true;
    }

    /***
     * The class for creating an hashcode for a object.
     * @return int Hashcode
     */
    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        return result;
    }
}
