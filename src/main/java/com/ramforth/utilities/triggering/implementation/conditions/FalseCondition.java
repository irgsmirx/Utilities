/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.conditions;

/**
 *
 * @author tobias
 */
public class FalseCondition extends AbstractCondition {
    
    @Override
    public boolean isMet() {
        return false;
    }

    @Override
    public String getFormatString() {
        return "FALSE";
    }
    
}
