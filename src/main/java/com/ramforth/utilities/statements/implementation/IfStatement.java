/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.statements.implementation;

import com.ramforth.utilities.expressions.interfaces.IExpression;
import com.ramforth.utilities.statements.interfaces.IIfStatement;
import com.ramforth.utilities.statements.interfaces.IStatement;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IfStatement extends AbstractStatement implements IIfStatement {

  private IExpression condition;
  private IStatement thenStatement;
  private IStatement elseStatement;
  
  public IfStatement(IExpression condition, IStatement thenStatement) {
    this.condition = condition;
    this.thenStatement = thenStatement;
  }
  
  public IfStatement(IExpression condition, IStatement thenStatement, IStatement elseStatement) {
    this(condition, thenStatement);
    this.elseStatement = elseStatement;
  }
  
  @Override
  public IExpression getCondition() {
    return condition;
  }

  @Override
  public void setCondition(IExpression value) {
    this.condition = value;
  }

  @Override
  public IStatement getThen() {
    return thenStatement;
  }

  @Override
  public void setThen(IStatement value) {
    this.thenStatement = value;
  }

  @Override
  public IStatement getElse() {
    return elseStatement;
  }

  @Override
  public void setElse(IStatement value) {
    this.elseStatement = value;
  }
  
}
