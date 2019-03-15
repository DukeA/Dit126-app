package dit126.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

/***
 * The class is an entity class which is
 * would be the data value for an location in this case.
 * The parameter which it has is in the form of latitude
 * and longitude of the City where it is located.
 */

@Entity
@Table(name = "location", schema = "public", catalog = "dit126")
public class LocationEntity {
    @Basic
    @Column(name = "latitude")
    @Getter
    @Setter
    private double latitude;
    @Basic
    @Column(name = "longitude")
    @Getter
    @Setter
    private double longitude;

    @Basic
    @Column(name = "city")
    @Getter
    @Setter
    private String city;

    @Id
    @SequenceGenerator(name="location_location_id_seq", sequenceName="location_location_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="location_location_id_seq")
    @NotNull
    @Column(name = "location_id", updatable=false)
    private Integer locationId;

    @OneToMany(mappedBy = "locationByLocationId")
    @Getter
    @Setter
    private Collection<ActivityEntity> activitiesByLocationId;

    /***
     * This method is for checking if two different Locations
     * are the Same  value  if they are then it will return true
     * @param o object in the form of  another class
     * @return boolean value
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationEntity that = (LocationEntity) o;

        if (Double.compare(that.latitude, latitude) != 0) return false;
        if (Double.compare(that.longitude, longitude) != 0) return false;
        if (locationId != that.locationId) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;

        return true;
    }

    /***
     *  The method is for creating an hashcode value for the  object.
     * @return hashcode value
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(latitude);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + locationId;
        return result;
    }
}
