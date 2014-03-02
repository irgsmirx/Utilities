/* 
 * Copyright (C) 2014 Tobias Ramforth
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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