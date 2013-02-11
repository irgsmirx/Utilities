/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.events;

import com.ramforth.utilities.triggering.interfaces.IEvent;

/**
 *
 * @author tobias
 */
public abstract class AbstractUnaryEvent extends AbstractEvent {
    
    protected IEvent childEvent;
    
    public IEvent getChildEvent() {
        return childEvent;
    }
    
    public void setChildEvent(IEvent value) {
        this.childEvent = value;
    }
    
    @Override
    public void reset() {
        childEvent.reset();
    }
    
}
