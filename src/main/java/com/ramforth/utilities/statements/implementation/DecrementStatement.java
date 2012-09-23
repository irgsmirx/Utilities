/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.statements.implementation;

import com.ramforth.utilities.expressions.interfaces.IParameterExpression;
import com.ramforth.utilities.statements.interfaces.IDecrementStatement;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class DecrementStatement extends AbstractStatement implements IDecrementStatement {

  private IParameterExpression target;
  
  public DecrementStatement(IParameterExpression target) {
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
