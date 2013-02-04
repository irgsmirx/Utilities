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
    public String getFormatString() {
        return "{leftChildEvent} OR {rightChildEvent}";
    }
    
}
