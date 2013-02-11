package com.ramforth.utilities.triggering.implementation.events;

import com.ramforth.utilities.time.implementation.DateTime;

//[Description("Ereignis, das eintritt, wenn eine gewisse Zeit vergangen ist.")]
//[Category("Timer")]
//[Serializable]
//[UserEditable]
public class TimeElapsedEvent extends AbstractEvent {

    private boolean eventOccurred = false;
    private DateTime lastOccurrance = null;
    private TimeSpan time = new TimeSpan(0, 0, 0);

    public TimeSpan getTime() {
        return time;
    }

    public void setTime(TimeSpan value) {
        this.time = value;
    }

    @Override
    public boolean occurred() {
        if (!eventOccurred) {
            DateTime now = DateTime.now();
            if (TimeSpan.ZERO.compareTo(time) < 0) {
                if (lastOccurrance != null) {
                    if (now.getTicks() >= lastOccurrance.getTicks() + time.getTicks()) {
                        eventOccurred = true;
                        lastOccurrance = now;
                    }
                } else {
                    lastOccurrance = now;
                }
            }
        }
        return eventOccurred;
    }

    @Override
    public void reset() {
    }

    @Override
    public String toString() {
        return String.format("Nach {%1s}", time.toString());
    }

    @Override
    public String getFormatString() {
        return "Nach {Time}";
    }
}