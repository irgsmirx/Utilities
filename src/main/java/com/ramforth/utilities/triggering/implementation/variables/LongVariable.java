/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.variables;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class LongVariable extends AbstractVariable {
 
    protected long value;
    
    public long getValue() {
        return value;
    }
    
    public void setValue(long value) {
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
