/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.expressions.implementation;

import com.ramforth.utilities.expressions.interfaces.IExpression;
import com.ramforth.utilities.expressions.interfaces.IMultiplyExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class MultiplyExpression extends AbstractBinaryExpression implements IMultiplyExpression {

    public MultiplyExpression(IExpression leftChild, IExpression rightChild) {
        super(leftChild, rightChild);
    }
}
