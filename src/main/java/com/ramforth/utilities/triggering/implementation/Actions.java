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

import com.ramforth.utilities.triggering.interfaces.IAction;
import com.ramforth.utilities.triggering.interfaces.IActions;
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
public class Actions implements IActions {

    protected static final Logger LOGGER = LoggerFactory.getLogger(Actions.class);

    private final List<IAction> actions = new ArrayList<>();
    
    @Override
    public void prepend(IAction value) {
        actions.add(0, value);
    }

    @Override
    public void append(IAction value) {
        actions.add(value);
    }

    @Override
    public void remove(IAction value) {
        actions.remove(value);
    }

    @Override
    public IAction removeAt(int index) {
        return actions.remove(index);
    }

    @Override
    public void clear() {
        actions.clear();
    }

    @Override
    public int numberOfActions() {
        return actions.size();
    }

    @Override
    public void perform() {
        for (IAction action : actions) {
            try {
                action.perform();
            }
            catch (Exception actionException) {
                LOGGER.error("Error performing action.", actionException);
            }        
        }
    }

    @Override
    public Iterator<IAction> iterator() {
        return actions.iterator();
    }
    
}
