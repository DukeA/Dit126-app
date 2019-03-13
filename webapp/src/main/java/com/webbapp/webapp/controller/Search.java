package com.webbapp.webapp.controller;

import com.webbapp.webapp.util.SearchEnum;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Since the Search field is injected in the navigation bar it's always present.
 * We believe it's better to reduce the number of objects created, so this is
 * a SessionScoped bean that holds the user's input for performing a search.
 */
@Named("searchBean")
@SessionScoped
public class Search implements Serializable {

    @Getter @Setter
    @NotBlank(message = "The search field is empty")
    private String text;

    @Getter @Setter
    private SearchEnum searchEnum;
}
