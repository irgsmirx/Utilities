/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.expressions.implementation;

import com.ramforth.utilities.expressions.interfaces.INotEqualExpression;
import com.ramforth.utilities.expressions.interfaces.IExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class NotEqualExpression extends AbstractConditionalExpression implements INotEqualExpression {

    public NotEqualExpression(IExpression leftChild, IExpression rightChild) {
        super(leftChild, rightChild);
    }
    
    @Override
    public String toString() {
        return String.format("%s != %s", leftChild, rightChild);
    }
    
}
