/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.expressions.implementation;

import com.ramforth.utilities.expressions.interfaces.IBinaryExpression;
import com.ramforth.utilities.expressions.interfaces.IExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class AbstractBinaryExpression extends AbstractExpression implements IBinaryExpression {

    protected IExpression leftChild;
    protected IExpression rightChild;

    public AbstractBinaryExpression(IExpression leftChild, IExpression rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public IExpression getLeftChild() {
        return leftChild;
    }

    @Override
    public void setLeftChild(IExpression value) {
        this.leftChild = value;
    }

    @Override
    public IExpression getRightChild() {
        return rightChild;
    }

    @Override
    public void setRightChild(IExpression value) {
        this.rightChild = value;
    }
}
