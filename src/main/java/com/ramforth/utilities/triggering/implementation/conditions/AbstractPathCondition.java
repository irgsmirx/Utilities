package com.ramforth.utilities.triggering.implementation.conditions;

//[Serializable]
public abstract class AbstractPathCondition extends AbstractCondition {

    protected String path = null;

    public String getPath() {
        return path;
    }

    public void setPath(String value) {
        this.path = value;
    }
}