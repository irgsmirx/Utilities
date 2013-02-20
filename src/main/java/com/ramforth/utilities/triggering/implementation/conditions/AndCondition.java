/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.conditions;

/**
 *
 * @author tobias
 */
public class AndCondition extends AbstractBinaryCondition {

    @Override
    public boolean isMet() {
        return leftChildCondition.isMet() && rightChildCondition.isMet();
    }

    @Override
    public String toString() {
        return String.format("(%s AND %s)", leftChildCondition, rightChildCondition);
    }
    
    @Override
    public String getFormatString() {
        return "({leftChildCondition} AND {rightChildCondition})";
    }
    
}
