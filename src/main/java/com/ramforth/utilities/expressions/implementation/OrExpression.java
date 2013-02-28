/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.expressions.implementation;

import com.ramforth.utilities.expressions.interfaces.IExpression;
import com.ramforth.utilities.expressions.interfaces.IOrExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class OrExpression extends AbstractConditionalExpression implements IOrExpression {

    public OrExpression(IExpression leftChild, IExpression rightChild) {
        super(leftChild, rightChild);
    }
    
    @Override
    public String toString() {
        return String.format("(%s OR %s)", leftChild, rightChild);
    }
    
}
