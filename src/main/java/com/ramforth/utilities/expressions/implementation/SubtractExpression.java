/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.expressions.implementation;

import com.ramforth.utilities.expressions.interfaces.ISubtractExpression;
import com.ramforth.utilities.expressions.interfaces.IExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class SubtractExpression extends AbstractBinaryExpression implements ISubtractExpression {

    public SubtractExpression(IExpression leftChild, IExpression rightChild) {
        super(leftChild, rightChild);
    }
}
