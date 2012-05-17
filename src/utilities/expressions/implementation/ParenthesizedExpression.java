/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.expressions.implementation;

import utilities.expressions.interfaces.IExpression;
import utilities.expressions.interfaces.IParenthesizedExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class ParenthesizedExpression extends AbstractUnaryExpression implements IParenthesizedExpression {

  public ParenthesizedExpression(IExpression child) {
    super(child);
  }
  
}
