package com.webbapp.webapp.model;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="ACTIVITY")
@XmlRootElement

public class Actvity {

    @Id
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "TYPE")
    private String type;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "LAT")
    private Double lat;
    @Basic(optional = false)
    @Column(name = "LNG")
    private Double lng;
    @Basic(optional =false)
    @Column(name = "USER")
    @OneToOne
    private Users username;



    public Actvity (String title,String type, String description,
                    Double lat , Double lng,Users username ) {
        this.title = title;
        this.type = type;
        this.description = description;
        this.lat = lat;
        this.lng = lng;
        this.username = username;
    }

    public Actvity( String title , String type,
                    Double lat, Double lng, Users username) {
        this.title = title;
        this.type = type;
        this.lat = lat;
        this.lng = lng;
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Users getUsername() {
        return username;
    }

    public void setUsername(Users username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (title != null ? title.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Actvity)) {
            return false;
        }
        Actvity actvity = (Actvity) object;
        if ((this.title == null && actvity.title != null)
        ||(this.title!= null && !this.title.equals(actvity.title))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
         return "model.Activity[ Title =" + title + "]" ;}
    }
}
