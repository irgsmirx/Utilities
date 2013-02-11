package com.ramforth.utilities.triggering.implementation.events;

public abstract class AbstractPathEvent extends AbstractEvent {

    protected String path = null;

    public String getPath() {
        return path;
    }

    public void setPath(String value) {
        this.path = value;
    }
}