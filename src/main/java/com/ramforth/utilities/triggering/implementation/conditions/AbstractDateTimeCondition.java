package com.ramforth.utilities.triggering.implementation.conditions;

import com.ramforth.utilities.time.implementation.DateTime;

//[Serializable]
public abstract class AbstractDateTimeCondition extends AbstractCondition {

    protected DateTime dateTime = DateTime.today();

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime value) {
        this.dateTime = value;
    }
}