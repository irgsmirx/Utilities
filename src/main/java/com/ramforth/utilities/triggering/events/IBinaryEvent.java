/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.events;

import com.ramforth.utilities.triggering.interfaces.IEvent;

/**
 *
 * @author tobias
 */
public interface IBinaryEvent extends IEvent {
    
    IEvent getLeftChildEvent();
    
    void setLeftChildEvent(IEvent value);
    
    IEvent getRightChildEvent();
    
    void setRigthChildEvent(IEvent value);
    
}
