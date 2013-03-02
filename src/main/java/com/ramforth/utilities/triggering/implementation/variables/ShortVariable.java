/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.variables;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class ShortVariable extends AbstractVariable {
    
    protected short value;
    
    public short getValue() {
        return value;
    }
    
    public void setValue(short value) {
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
