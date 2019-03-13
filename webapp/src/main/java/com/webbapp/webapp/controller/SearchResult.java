package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.ActivityEntity;
import com.webbapp.webapp.model.ActivityFacade;
import com.webbapp.webapp.util.SearchEnum;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * RequestScoped bean that performs a search based on
 * the user's input from Search.java.
 */
@Named("searchResult")
@RequestScoped
public class SearchResult implements Serializable {

    @Getter
    private List<ActivityEntity> activityEntities;

    @Getter
    private String text;

    @Getter
    private Integer size;

    @Getter
    private SearchEnum searchEnum;

    @Inject
    private ActivityFacade activityFacade;

    @Inject
    private Search searchBean;

    @PostConstruct
    private void post() {
        text = searchBean.getText().trim().toLowerCase();;
        searchEnum = searchBean.getSearchEnum();
    }

    public void search() {

        if (searchEnum == SearchEnum.TYPE) {
            this.findByType(text);
        } else if (searchEnum == SearchEnum.CITY) {
            this.findByCity(text);
        }

        size = activityEntities.size();
        searchBean.setText("");
    }

    private void findByType(String type) {
        activityEntities = activityFacade.findByType(type);
    }

    private void findByCity(String city) {
        activityEntities = activityFacade.findByCity(city);
    }

}
