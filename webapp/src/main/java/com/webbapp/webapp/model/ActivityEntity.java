package com.webbapp.webapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "activity", schema = "public", catalog = "dit126")
public class ActivityEntity {

    @Id
    @SequenceGenerator(name="activity_activity_id_seq", sequenceName="activity_activity_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="activity_activity_id_seq")
    @NotNull
    @Column(name = "activity_id", updatable=false)
    private Integer activityId;

    @Basic
    @Column(name = "title")
    @Getter
    @Setter
    private String title;
    @Basic
    @Column(name = "activity")
    @Getter
    @Setter
    private String activity;
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
    private AppUsersEntity appUsersByUserId;




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
}
