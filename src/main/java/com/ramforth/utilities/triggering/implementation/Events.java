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

package com.ramforth.utilities.triggering.implementation;

import com.ramforth.utilities.triggering.interfaces.IEvent;
import com.ramforth.utilities.triggering.interfaces.IEvents;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Tobias Ramforth
 */
public class Events implements IEvents {

    protected static final Logger LOGGER = LoggerFactory.getLogger(Events.class);

    private final List<IEvent> events = new ArrayList<>();
    
    @Override
    public void prepend(IEvent value) {
        events.add(0, value);
    }

    @Override
    public void append(IEvent value) {
        events.add(value);
    }

    @Override
    public void remove(IEvent value) {
        events.remove(value);
    }

    @Override
    public IEvent removeAt(int index) {
        return events.remove(index);
    }

    @Override
    public void clear() {
        events.clear();
    }

    @Override
    public int numberOfEvents() {
        return events.size();
    }

    @Override
    public boolean occurred() {
        for (IEvent event : events) {
            try {
                if (event.occurred()) {
                    event.reset();
                    return true;
                }
            }
            catch (Exception eventException) {
                LOGGER.error("Error checking if event occurred.", eventException);
            }        
        }
        
        return false;
    }

    @Override
    public Iterator<IEvent> iterator() {
        return events.iterator();
    }
    
}
