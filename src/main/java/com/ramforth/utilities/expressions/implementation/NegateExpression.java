/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.expressions.implementation;

import com.ramforth.utilities.expressions.interfaces.IExpression;
import com.ramforth.utilities.expressions.interfaces.INegateExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class NegateExpression extends AbstractUnaryExpression implements INegateExpression {

    public NegateExpression(IExpression child) {
        super(child);
    }
    
    @Override
    public String toString() {
        return String.format("(-%s)", child);
    }
    
}
