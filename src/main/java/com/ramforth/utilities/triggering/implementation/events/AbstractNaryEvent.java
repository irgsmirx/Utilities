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

import com.ramforth.utilities.triggering.events.INaryEvent;
import com.ramforth.utilities.triggering.interfaces.IEvent;
import java.util.List;

/**
 *
 * @author tobias
 */
public abstract class AbstractNaryEvent extends AbstractEvent implements INaryEvent {
    
    protected List<IEvent> childEvents;
    
    @Override
    public Iterable<IEvent> getChildEvents() {
        return childEvents;
    }
    
    @Override
    public void reset() {
        for (IEvent childEvent : childEvents) {
            childEvent.reset();
        }
    }
    
}
