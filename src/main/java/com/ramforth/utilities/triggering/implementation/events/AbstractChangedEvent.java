package com.ramforth.utilities.triggering.implementation.events;

//@Category("File")
public abstract class AbstractChangedEvent extends AbstractEvent {

    private boolean lastTime = false;

    @Override
    public boolean occurred() {
        boolean eventOccurred = false;

        if (lastTime) {
            if (test()) {
                eventOccurred = true;
                lastTime = false;
            }
        } else {
            if (!test()) {
                lastTime = true;
            }
        }

        return eventOccurred;
    }

    public abstract boolean test();

    @Override
    public void reset() {
        lastTime = false;
    }
}
