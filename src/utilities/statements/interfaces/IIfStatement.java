/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.statements.interfaces;

import utilities.expressions.interfaces.IExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public interface IIfStatement extends IStatement {
  
  IExpression getCondition();
  void setCondition(IExpression value);
  
  IStatement getThen();
  void setThen(IStatement value);
  
  IStatement getElse();
  void setElse(IStatement value);
  
}
