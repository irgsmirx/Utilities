/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.conditions;

import com.ramforth.utilities.triggering.interfaces.ICondition;

/**
 *
 * @author tobias
 */
public interface INaryCondition extends ICondition {
    
    Iterable<ICondition> getChildConditions();
    
}
