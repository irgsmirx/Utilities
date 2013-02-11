package com.ramforth.utilities.triggering.implementation.events;

import com.ramforth.utilities.time.implementation.DateTime;

//[Description("Ereignis, das periodisch eintritt.")]
//[Category("Timer")]
//[Serializable]
//[UserEditable]
public class PeriodicEvent extends AbstractEvent {

    private DateTime lastOccurrance = null;
    private TimeSpan period = TimeSpan.ZERO;

    public TimeSpan getPeriod() {
        return period;
    }

    public void setPeriod(TimeSpan value) {
        this.period = value;
    }

    @Override
    public boolean occurred() {
        boolean eventOccurred = false;
        DateTime now = DateTime.now();
        if (TimeSpan.ZERO.compareTo(period) < 0) {
            if (lastOccurrance != null) {
                if (now.getTicks() >= lastOccurrance.getTicks() + period.getTicks()) {
                    eventOccurred = true;
                    lastOccurrance = now;
                }
            } else {
                lastOccurrance = now;
            }
        }
        return eventOccurred;
    }

    @Override
    public void reset() {
    }

    public String ToString() {
        return String.format("Alle {%1s}", period.toString());
    }

    @Override
    public String getFormatString() {
        return "Alle {period}";
    }
}