package com.webbapp.webapp.controller.search;

import com.webbapp.webapp.model.entity.ActivityEntity;
import com.webbapp.webapp.model.facade.SearchFacade;
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
    private SearchFacade searchFacade;

    @Inject
    private Search searchBean;

    @PostConstruct
    private void post() {
        text = searchBean.getText().trim();
        searchEnum = searchBean.getSearchEnum();
    }

    public void search() {

        if (searchEnum == SearchEnum.TYPE) {
            this.findByType(text.toUpperCase());
        } else if (searchEnum == SearchEnum.CITY) {
            this.findByCity(text.toLowerCase());
        }

        size = activityEntities.size();
        searchBean.setText("");
    }

    private void findByType(String type) {
        activityEntities = searchFacade.findByType(type);
    }

    private void findByCity(String city) {
        activityEntities = searchFacade.findByCity(city);
    }

}
