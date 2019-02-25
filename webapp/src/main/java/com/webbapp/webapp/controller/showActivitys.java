package com.webbapp.webapp.controller;


import com.webbapp.webapp.model.showActivity;
import com.webbapp.webapp.model.showActivityFacade;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Adam Grandén
 *
 *
 */

@Named(value = "showAct")
@ViewScoped
public class showActivitys implements Serializable {

    private  String title;
    private  String type;
    private  String description;


    @Inject
    showActivityFacade activityFacade;

    private showActivity activity;


    public String activity (){
        return null;
    }


    public void SetActivity(String act) {

    }

    public String getTitle() {
        return this.title;
    }

    public String getType(){
        return  this.type;
    }

    public String getDescription(){
        return this.description;
    }



}
