package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.ActivityFacade;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Named("searchBean")
@RequestScoped
public class Search implements Serializable {

    @Getter
    @Setter
    @NotBlank(message = "The search field is empty")
    private String text;

    @Inject
    private ActivityFacade activityFacade;

    public void search() {
        System.out.println(activityFacade.findAll().get(0).getTitle());
    }
}
