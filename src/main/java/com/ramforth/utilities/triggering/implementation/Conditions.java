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

import com.ramforth.utilities.triggering.interfaces.ICondition;
import com.ramforth.utilities.triggering.interfaces.IConditions;
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
public class Conditions implements IConditions {

    protected static final Logger LOGGER = LoggerFactory.getLogger(Conditions.class);

    private final List<ICondition> conditions = new ArrayList<>();
    
    @Override
    public void prepend(ICondition value) {
        conditions.add(0, value);
    }

    @Override
    public void append(ICondition value) {
        conditions.add(value);
    }

    @Override
    public void remove(ICondition value) {
        conditions.remove(value);
    }

    @Override
    public ICondition removeAt(int index) {
        return conditions.remove(index);
    }

    @Override
    public void clear() {
        conditions.clear();
    }

    @Override
    public int numberOfConditions() {
        return conditions.size();
    }

    @Override
    public boolean areMet() {
        for (ICondition condition : conditions) {
            try {
                if (!condition.isMet()) {
                    return false;
                }
            }
            catch (Exception conditionException) {
                LOGGER.error("Error checking if condition is met.", conditionException);
            }        
        }
        
        return true;
    }

    @Override
    public Iterator<ICondition> iterator() {
        return conditions.iterator();
    }
    
}
