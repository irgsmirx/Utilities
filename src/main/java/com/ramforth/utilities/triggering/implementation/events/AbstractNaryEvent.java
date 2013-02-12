/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.events;

import com.ramforth.utilities.triggering.events.INaryEvent;
import com.ramforth.utilities.triggering.interfaces.IEvent;
import java.util.List;

/**
 *
 * @author tobias
 */
public abstract class AbstractNaryEvent extends AbstractEvent implements INaryEvent {
    
    protected List<IEvent> childEvents;
    
    @Override
    public Iterable<IEvent> getChildEvents() {
        return childEvents;
    }
    
    @Override
    public void reset() {
        for (IEvent childEvent : childEvents) {
            childEvent.reset();
        }
    }
    
}
