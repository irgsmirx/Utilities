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
package com.ramforth.utilities.triggering.interfaces;

/**
 *
 * @author tobias
 */
public interface ITrigger {
    
    String getName();
    void setName(String value);

    void evaluate();
    void clear();

    Iterable<IEvent> getEvents();
    void clearEvents();
    void addEvent(IEvent e);
    void removeEvent(IEvent e);
    void removeEventAt(int index);

    Iterable<IVariable> getVariables();
    void clearVariables();
    void addVariable(IVariable v);
    void removeVariable(IVariable v);
    void removeVariableAt(int index);    
    
    Iterable<ICondition> getConditions();
    void clearConditions();
    void addCondition(ICondition e);
    void removeCondition(ICondition e);
    void removeConditionAt(int index);
    
    Iterable<IAction> getActions();
    void clearActions();
    void addAction(IAction e);
    void removeAction(IAction e);
    void removeActionAt(int index);
    
    
}
