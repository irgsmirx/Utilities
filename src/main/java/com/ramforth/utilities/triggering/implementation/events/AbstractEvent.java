/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.events;

import com.ramforth.utilities.triggering.implementation.AbstractTriggerChild;
import com.ramforth.utilities.triggering.interfaces.IEvent;

/**
 *
 * @author tobias
 */
public abstract class AbstractEvent extends AbstractTriggerChild  implements IEvent {

    @Override
    public abstract boolean occurred();
    
}
