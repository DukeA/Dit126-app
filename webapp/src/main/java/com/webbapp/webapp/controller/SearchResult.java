package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.ActivityEntity;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("searchResult")
@ViewScoped
public class SearchResult implements Serializable {

    @Getter
    private List<ActivityEntity> activityEntities;

    @Getter
    private String text;

    @Getter
    private Integer size;

    @PostConstruct
    private void post() {
        activityEntities = (List<ActivityEntity>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("activityEntities");
        text = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("text");
        size = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("size");
    }

}
