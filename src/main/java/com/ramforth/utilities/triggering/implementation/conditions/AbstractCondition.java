/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.conditions;

import com.ramforth.utilities.triggering.implementation.AbstractTriggerChild;
import com.ramforth.utilities.triggering.interfaces.ICondition;

/**
 *
 * @author tobias
 */
public abstract class AbstractCondition extends AbstractTriggerChild  implements ICondition {
 
    @Override
    public abstract boolean isMet();
    
}
