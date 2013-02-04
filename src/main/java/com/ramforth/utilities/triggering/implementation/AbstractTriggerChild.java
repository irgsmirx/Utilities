/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation;

import com.ramforth.utilities.triggering.interfaces.ITrigger;
import com.ramforth.utilities.triggering.interfaces.ITriggerChild;

/**
 *
 * @author tobias
 */
public abstract class AbstractTriggerChild implements ITriggerChild {
    
    protected ITrigger parent;
    
    @Override
    public ITrigger getParent() {
        return parent;
    }
    
    @Override
    public abstract String getFormatString();
    
}
