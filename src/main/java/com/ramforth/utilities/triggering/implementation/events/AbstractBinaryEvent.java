/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.events;

import com.ramforth.utilities.triggering.events.IBinaryEvent;
import com.ramforth.utilities.triggering.interfaces.IEvent;

/**
 *
 * @author tobias
 */
public abstract class AbstractBinaryEvent extends AbstractEvent implements IBinaryEvent {
    
    protected IEvent leftChildEvent;
    protected IEvent rightChildEvent;
    
    @Override
    public IEvent getLeftChildEvent() {
        return leftChildEvent;
    }
    
    @Override
    public void setLeftChildEvent(IEvent value) {
        this.leftChildEvent = value;
    }
    
    @Override
    public IEvent getRightChildEvent() {
        return rightChildEvent;
    }
    
    @Override
    public void setRigthChildEvent(IEvent value) {
        this.rightChildEvent = value;
    }
    
    @Override
    public void reset() {
        leftChildEvent.reset();
        rightChildEvent.reset();
    }
    
}
