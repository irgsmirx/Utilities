/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.statements.interfaces;

import utilities.expressions.interfaces.IParameterExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public interface IDecrementStatement extends IStatement {
  
  IParameterExpression getTarget();
  void setTarget(IParameterExpression value);
  
}
