package com.webbapp.webapp.controller;

import com.webbapp.webapp.util.SearchEnum;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Named("searchBean")
@SessionScoped
public class Search implements Serializable {

    @Getter @Setter
    @NotBlank(message = "The search field is empty")
    private String text;

    @Getter @Setter
    private SearchEnum searchEnum;
}
