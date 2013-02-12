/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.events;

import com.ramforth.utilities.triggering.events.IUnaryEvent;
import com.ramforth.utilities.triggering.interfaces.IEvent;

/**
 *
 * @author tobias
 */
public abstract class AbstractUnaryEvent extends AbstractEvent implements IUnaryEvent {
    
    protected IEvent childEvent;
    
    @Override
    public IEvent getChildEvent() {
        return childEvent;
    }
    
    @Override
    public void setChildEvent(IEvent value) {
        this.childEvent = value;
    }
    
    @Override
    public void reset() {
        childEvent.reset();
    }
    
}
