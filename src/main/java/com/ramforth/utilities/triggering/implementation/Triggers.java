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
import com.ramforth.utilities.triggering.interfaces.ICondition;
import com.ramforth.utilities.triggering.interfaces.IEvent;
import com.ramforth.utilities.triggering.interfaces.ITrigger;
import com.ramforth.utilities.triggering.interfaces.ITriggers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Tobias Ramforth
 */
public class Triggers implements ITriggers {

    protected static final Logger LOGGER = LoggerFactory.getLogger(Triggers.class);

    private final List<ITrigger> triggers = new ArrayList<>();

    @Override
    public void prepend(ITrigger value) {
        triggers.add(0, value);
    }

    @Override
    public void append(ITrigger value) {
        triggers.add(value);
    }

    @Override
    public boolean remove(ITrigger value) {
        return triggers.remove(value);
    }

    @Override
    public ITrigger removeAt(int index) {
        return triggers.remove(index);
    }

    @Override
    public void clear() {
        triggers.clear();
    }

    @Override
    public int numberOfTriggers() {
        return triggers.size();
    }

    @Override
    public Iterator<ITrigger> iterator() {
        return triggers.iterator();
    }

    @Override
    public void evaluate() {
        for (ITrigger trigger : triggers) {
            trigger.evaluate();
        }
    }

}
