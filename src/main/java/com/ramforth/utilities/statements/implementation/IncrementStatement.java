/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.statements.implementation;

import com.ramforth.utilities.expressions.interfaces.IParameterExpression;
import com.ramforth.utilities.statements.interfaces.IIncrementStatement;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IncrementStatement extends AbstractStatement implements IIncrementStatement {

  private IParameterExpression target;
  
  public IncrementStatement(IParameterExpression target) {
    this.target = target;
  }

  @Override
  public IParameterExpression getTarget() {
    return target;
  }

  @Override
  public void setTarget(IParameterExpression value) {
    this.target = value;
  }
  
}
