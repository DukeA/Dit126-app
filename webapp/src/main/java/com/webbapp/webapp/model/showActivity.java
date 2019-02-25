package com.webbapp.webapp.model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
@NamedQuery(name = "showActivity.findAll",query = "SELECT u from showActivity u")
, @NamedQuery(name = "showActivty.findTitle", query ="SELECT  u from showActivity")
, @NamedQuery(name = "showActivity.findType" ,query = "SELECT u from showActivty")
, @NamedQuery(name= )

public class showActivity implements Serializable {
}
