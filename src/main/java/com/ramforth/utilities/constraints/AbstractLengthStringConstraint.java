/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.constraints;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public abstract class AbstractLengthStringConstraint extends AbstractStringConstraint {
    
    protected int length;
    
    public AbstractLengthStringConstraint(int length) {
        this.length = length;
    }
    
}
