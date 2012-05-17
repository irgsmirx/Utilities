/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.expressions.implementation;

import utilities.expressions.interfaces.IExpression;
import utilities.expressions.interfaces.INotExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class NotExpression extends AbstractUnaryExpression implements INotExpression {

  public NotExpression(IExpression child) {
    super(child);
  }
  
}
