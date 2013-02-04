/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.conditions;

import com.ramforth.utilities.triggering.interfaces.ICondition;

/**
 *
 * @author tobias
 */
public abstract class AbstractUnaryCondition extends AbstractCondition {
    
    protected ICondition childCondition;
    
    public ICondition getChildCondition() {
        return childCondition;
    }
    
    public void setChildCondition(ICondition value) {
        this.childCondition = value;
    }
           
    
}
