package com.webbapp.webapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "activity", schema = "public", catalog = "dit126")
@NamedQueries({
        @NamedQuery(
            name = "ActivityEntity.findByType",
            query = "SELECT a FROM ActivityEntity a WHERE a.type = :type"
        ),
        @NamedQuery(
            name = "ActivityEntity.findByCity",
            query = "SELECT a FROM ActivityEntity a, LocationEntity l WHERE l.city = :city"
        )
})
public class ActivityEntity {

    @Getter @Setter
    @Id
    @Column(name = "activity_id")
    private String id;

    private String title;
    private String type;
    private String description;

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
