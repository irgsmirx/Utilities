/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.variables;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class DoubleVariable extends AbstractVariable  {
    
    protected double value;
    
    public double getValue() {
        return value;
    }
    
    public void setValue(double value) {
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
