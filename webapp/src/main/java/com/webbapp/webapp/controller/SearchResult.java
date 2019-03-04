package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.ActivityEntity;
import com.webbapp.webapp.util.SearchEnum;
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

    @Getter
    private SearchEnum searchEnum;

    @PostConstruct
    private void post() {
        activityEntities = (List<ActivityEntity>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("activityEntities");
        text = (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("text");
        size = (Integer) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("size");
        searchEnum = (SearchEnum) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("searchEnum");
    }

}
