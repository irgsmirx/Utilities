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
