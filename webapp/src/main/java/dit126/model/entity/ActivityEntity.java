package dit126.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/***
 * The class is  an representation of the Activity class.
 * Which have a locationEntity and a User which  have created it.
 */
@Entity
@Table(name = "activity", schema = "public", catalog = "dit126")
@NamedQueries({
        @NamedQuery(
            name  = "ActivityEntity.findByType",
            query = "SELECT a FROM ActivityEntity a WHERE a.type = :type"
        ),
        @NamedQuery(
            name  = "ActivityEntity.findByCity",
            query = "SELECT a FROM ActivityEntity a, LocationEntity l " +
                    "WHERE a.locationByLocationId.locationId = l.locationId AND l.city = :city"
        ),@NamedQuery(
            name  = "activity.getActivity" ,
            query = "SELECT u FROM ActivityEntity  u WHERE u.title = :title AND u.type = :type")
        ,@NamedQuery(
            name  ="ActivityEntity.findByActivityId",
            query = "SELECT u FROM ActivityEntity  u WHERE u.activityId =:ActivityId")
        ,
        @NamedQuery(
            name  = "ActivityEntity.findByTypes",
            query = "SELECT a FROM ActivityEntity a WHERE a.type IN :types")
})
public class ActivityEntity {
    
    @Id
    @SequenceGenerator(name="activity_activity_id_seq", sequenceName="activity_activity_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="activity_activity_id_seq")
    @NotNull
    @Column(name = "activity_id", updatable=false)
    @Getter
    private Integer activityId;

    @Basic
    @Column(name = "title")
    @Getter
    @Setter
    private String title;
    @Basic
    @Column(name = "type")
    @Getter
    @Setter
    private String type;
    @Basic
    @Column(name = "description")
    @Getter
    @Setter
    private String description;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    @Getter
    @Setter
    private LocationEntity locationByLocationId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @Getter
    @Setter
    private AppUserEntity appUsersByUserId;


    /***
     * An Method for checking if two classes are equal to each other ,
     * this is done by checking the  different values which the two classes have
     * @param o another object in this case
     * @return boolean value of true/false
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityEntity that = (ActivityEntity) o;

        if (activityId != null ? !activityId.equals(that.activityId) : that.activityId != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    /***
     * An method for creating an hashcode value for the class
     * @return int value
     */
    @Override
    public int hashCode() {
        int result = activityId != null ? activityId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
