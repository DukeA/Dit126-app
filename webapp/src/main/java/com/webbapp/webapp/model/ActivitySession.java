package com.webbapp.webapp.model;

public class ActivitySession {
    private static ActivitySession ourInstance = new ActivitySession();

    public static ActivitySession getInstance() {
        return ourInstance;
    }

    private ActivitySession() {
    }
}
