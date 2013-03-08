/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.constraints;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class MinimumLengthStringConstraint extends AbstractLengthStringConstraint {
 
    public MinimumLengthStringConstraint(int length) {
        super(length);
    }

    @Override
    public boolean isSatisfied(String value) {
        return value.length() >= length;
    }

    
}
