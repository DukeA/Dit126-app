package com.webbapp.webapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/***
 * @Author: Adam Grandén
 * @Class: The class is an class to get the  values
 * from the Activities by showing the information of the activity
 * and the
 */

@Entity
@Table(name ="SHOWACT")
@XmlRootElement


public class showActivity implements Serializable {

    private  static final long serialVersionUID =1L;

    @Id
    @Basic (optional = false)
    @Column(name = "TITLE")
    private String title;

    @Basic(optional = false)
    @Column(name = "TYPE")
    private String type;

    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;

    @Basic(optional = false)
    @Column(name="LAT")
    private double lat;

    @Basic(optional = false)
    @Column(name = "LNG")
    private double lng;

    public showActivity(){

    }

    public showActivity(String title, String type, String  description
            , float  lat, float lng){
        this.title = title;
        this.type = type;
        this.description = description;
        this.lat = lat;
        this.lng = lng;

    }

    public  void setTitle (String  title) {
        this.title = title;
    }
    public String getTitle () {
        return this.title;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }
    public void setDescription(String des) {
        this.description = des;
    }
    public String getDescription() {
        return this.description;
    }
    public double getLat() {
        return lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
    public double getLng() {
        return lng;
    }
    public void setLng(double lng) {
        this.lng = lng;
    }
}
