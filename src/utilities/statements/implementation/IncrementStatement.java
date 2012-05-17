/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.statements.implementation;

import utilities.expressions.interfaces.IParameterExpression;
import utilities.statements.interfaces.IIncrementStatement;

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
