package com.ramforth.utilities.triggering.implementation.events;

public abstract class AbstractResettableEvent extends AbstractEvent {

    protected boolean eventOccurred = false;

    @Override
    public boolean occurred() {
        return eventOccurred;
    }

    @Override
    public void reset() {
        eventOccurred = false;
    }
}