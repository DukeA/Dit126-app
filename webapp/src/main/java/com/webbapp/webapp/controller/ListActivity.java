package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.entity.ActivityEntity;
import com.webbapp.webapp.model.facade.ListActivityFacade;
import lombok.Getter;
import lombok.Setter;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@ViewScoped
public class ListActivity implements Serializable {
    @Getter
    @Setter
    private String types;

    @Inject
    ListActivityFacade activityFacade;


    public List<ActivityEntity> getList() {
        List<ActivityEntity> activities = activityFacade.findByTypes(Arrays.asList(types.split(",")));

        return activities;
    }
}