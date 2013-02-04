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
public abstract class AbstractBinaryCondition extends AbstractCondition {
    
    protected ICondition leftChildCondition;
    protected ICondition rightChildCondition;
    
    public ICondition getLeftChildCondition() {
        return leftChildCondition;
    }
    
    public void setLeftChildCondition(ICondition value) {
        this.leftChildCondition = value;
    }

    public ICondition getRightChildCondition() {
        return rightChildCondition;
    }

    public void setRightChildCondition(ICondition value) {
        this.rightChildCondition = value;
    }
    
}
