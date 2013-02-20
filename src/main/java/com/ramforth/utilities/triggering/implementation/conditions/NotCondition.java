/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.conditions;

/**
 *
 * @author tobias
 */
public class NotCondition extends AbstractUnaryCondition {

    @Override
    public boolean isMet() {
        return !childCondition.isMet();
    }

    @Override
    public String toString() {
        return String.format("NOT(%s)", childCondition.toString());
    }
    
    @Override
    public String getFormatString() {
        return "NOT({childCondition})";
    }
    
}
