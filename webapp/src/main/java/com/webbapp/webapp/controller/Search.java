package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.ActivityEntity;
import com.webbapp.webapp.model.ActivityFacade;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Named("searchBean")
@RequestScoped
public class Search implements Serializable {

    @Getter
    @Setter
    @NotBlank(message = "The search field is empty")
    private String text;

    @Inject
    private ActivityFacade activityFacade;

    @Getter
    private List<ActivityEntity> activityEntities;

    @PostConstruct
    private void post() {
        activityEntities = activityFacade.findAll();
    }

    public void search() {

    }
}
