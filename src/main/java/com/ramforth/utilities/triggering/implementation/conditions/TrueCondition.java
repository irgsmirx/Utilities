/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.conditions;

/**
 *
 * @author tobias
 */
public class TrueCondition extends AbstractCondition {

    @Override
    public boolean isMet() {
        return true;
    }

    @Override
    public String getFormatString() {
        return "TRUE";
    }
    
}
