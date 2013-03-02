/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.variables;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IntegerVariable extends AbstractVariable  {
    
    protected int value;

    public int getValue() {
        return value;
    }
    
    public void setValue(int value) {
        this.value = value;
    }
    
    @Override
    public String getFormatString() {
        return "{name} = {value}";
    }
    
    @Override
    public String toString() {
        return String.format("%s = %s", name, value);
    }
    
}
