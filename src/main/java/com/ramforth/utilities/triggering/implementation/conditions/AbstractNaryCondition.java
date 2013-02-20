/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.conditions;

import com.ramforth.utilities.triggering.conditions.INaryCondition;
import com.ramforth.utilities.triggering.interfaces.ICondition;
import java.util.List;

/**
 *
 * @author tobias
 */
public abstract class AbstractNaryCondition extends AbstractCondition implements INaryCondition {
    
    protected List<ICondition> childConditions;
    
    @Override
    public Iterable<ICondition> getChildConditions() {
        return childConditions;
    }
    
}
