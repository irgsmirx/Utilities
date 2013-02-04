/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
