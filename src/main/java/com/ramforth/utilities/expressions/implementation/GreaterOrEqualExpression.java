/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.expressions.implementation;

import com.ramforth.utilities.expressions.interfaces.IExpression;
import com.ramforth.utilities.expressions.interfaces.IGreaterOrEqualExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class GreaterOrEqualExpression extends AbstractConditionalExpression implements IGreaterOrEqualExpression {

    public GreaterOrEqualExpression(IExpression leftChild, IExpression rightChild) {
        super(leftChild, rightChild);
    }
    
    @Override
    public String toString() {
        return String.format("%s >= %s", leftChild, rightChild);
    }
    
}
