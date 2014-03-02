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
        return "Nach {time}";
    }
}