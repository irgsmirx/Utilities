/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.expressions.implementation;

import utilities.expressions.interfaces.IExpression;
import utilities.expressions.interfaces.IUnaryExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class AbstractUnaryExpression extends AbstractExpression implements IUnaryExpression {

  protected IExpression child;
  
  public AbstractUnaryExpression(IExpression child) {
    this.child = child;
  }
  
  @Override
  public IExpression getChild() {
    return child;
  }

  @Override
  public void setChild(IExpression value) {
    this.child = value;
  }
  
}
