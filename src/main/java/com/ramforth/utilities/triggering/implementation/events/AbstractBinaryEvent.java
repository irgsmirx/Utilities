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
public abstract class AbstractBinaryEvent extends AbstractEvent {
    
    protected IEvent leftChildEvent;
    protected IEvent rightChildEvent;
    
    public IEvent getLeftChildEvent() {
        return leftChildEvent;
    }
    
    public void setLeftChildEvent(IEvent value) {
        this.leftChildEvent = value;
    }
    
    public IEvent getRightChildEvent() {
        return rightChildEvent;
    }
    
    public void setRigthChildEvent(IEvent value) {
        this.rightChildEvent = value;
    }
    
}
