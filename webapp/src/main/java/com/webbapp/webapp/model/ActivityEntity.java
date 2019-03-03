package com.webbapp.webapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "activity", schema = "public", catalog = "dit126")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name="activity.find_all", query = "SELECT u FROM  ActivityEntity  u")
        ,@NamedQuery(name="activity.findActivityId", query="SELECT  u from ActivityEntity  u WHERE u.activityId = :activityId")
        ,@NamedQuery(name="activity.findtitle",query = "SELECT u FROM ActivityEntity u WHERE u.title = :title")
        ,@NamedQuery(name ="activity.findactivity" ,query = "SELECT u from ActivityEntity u WHERE u.activity = :activity")
        ,@NamedQuery(name="activity.findDescription",query = "SELECT u from ActivityEntity  u WHERE u.description = :description")
        ,@NamedQuery(name="activity.findlocation",query="SELECT u FROM ActivityEntity  u WHERE u.locationByLocationId = :locationByLocationId")
        ,@NamedQuery(name="activity.findUser_id" ,query = "SELECT u FROM ActivityEntity  u WHERE u.appUsersByUserId = :appUsersByUSerid")
        ,@NamedQuery(name="activity.getActivity" ,query = "SELECT u FROM ActivityEntity  u WHERE u.title = :title AND u.activity = :activity")
})
public class ActivityEntity {
    private String activityId;
    private String title;
    private String activity;
    private String description;
    private LocationEntity locationByLocationId;
    private AppUsersEntity appUsersByUserId;

    public ActivityEntity() {

    }

    public ActivityEntity(String activityId,String title, String type, String description, LocationEntity entity) {
        this.activityId = activityId;
        this.title = title;
        this.activity = type;
        this.description = description;
        this.locationByLocationId = entity;
    }

    @Id
    @Column(name = "activity_id")
    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "activity")
    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityEntity that = (ActivityEntity) o;

        if (activityId != null ? !activityId.equals(that.activityId) : that.activityId != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (activity != null ? !activity.equals(that.activity) : that.activity != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = activityId != null ? activityId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (activity != null ? activity.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    public LocationEntity getLocationByLocationId() {
        return locationByLocationId;
    }

    public void setLocationByLocationId(LocationEntity locationByLocationId) {
        this.locationByLocationId = locationByLocationId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public AppUsersEntity getAppUsersByUserId() {
        return appUsersByUserId;
    }

    public void setAppUsersByUserId(AppUsersEntity appUsersByUserId) {
        this.appUsersByUserId = appUsersByUserId;
    }
}
