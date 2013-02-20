/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.events;

/**
 *
 * @author tobias
 */
public class OrEvent extends AbstractBinaryEvent {
    
    @Override
    public boolean occurred() {
        return leftChildEvent.occurred() || rightChildEvent.occurred();
    }

    @Override
    public String toString() {
        return String.format("(%s OR %s)", leftChildEvent, rightChildEvent);
    }
    
    @Override
    public String getFormatString() {
        return "{leftChildEvent} OR {rightChildEvent}";
    }
    
}
