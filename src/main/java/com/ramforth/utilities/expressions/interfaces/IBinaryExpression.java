/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.expressions.interfaces;

/**
 *
 * @author tobias
 */
public interface IBinaryExpression extends IExpression {

    IExpression getLeftChild();

    void setLeftChild(IExpression value);

    IExpression getRightChild();

    void setRightChild(IExpression value);
}
