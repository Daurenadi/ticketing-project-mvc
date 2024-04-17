package com.cydeo.enums;

public enum ProjectStatus {

    OPEN("Open"), IN_PROGRESS("In Progress"), COMPLETE("Completed");

    private final String value;


    ProjectStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
