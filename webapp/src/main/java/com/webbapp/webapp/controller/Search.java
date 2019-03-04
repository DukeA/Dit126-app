package com.webbapp.webapp.controller;

import com.webbapp.webapp.model.ActivityEntity;
import com.webbapp.webapp.model.ActivityFacade;
import com.webbapp.webapp.util.SearchEnum;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Named("searchBean")
@RequestScoped
public class Search implements Serializable {

    @Getter @Setter
    @NotBlank(message = "The search field is empty")
    private String text;

    @Getter @Setter
    private SearchEnum searchEnum;

    @Inject
    private ActivityFacade activityFacade;

    private List<ActivityEntity> activityEntities;

    public void search() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("text", text);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("searchEnum", searchEnum);

        this.prepareString();

        if (searchEnum == SearchEnum.TYPE) {
            this.findByType(text);
        } else if (searchEnum == SearchEnum.CITY) {
            this.findByCity(text);
        }

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("activityEntities", activityEntities);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("size", activityEntities.size());
    }

    private void findByType(String type) {
        activityEntities = activityFacade.findByType(type);
    }

    private void findByCity(String city) {
        activityEntities = activityFacade.findByCity(city);
    }

    void prepareString() {
        text = text.trim().toLowerCase();
    }
}
