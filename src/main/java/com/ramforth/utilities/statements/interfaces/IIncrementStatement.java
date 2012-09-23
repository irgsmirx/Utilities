/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.statements.interfaces;

import com.ramforth.utilities.expressions.interfaces.IParameterExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public interface IIncrementStatement extends IStatement {

    IParameterExpression getTarget();

    void setTarget(IParameterExpression value);
}
