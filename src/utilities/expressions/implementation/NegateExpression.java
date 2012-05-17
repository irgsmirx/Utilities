/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.expressions.implementation;

import utilities.expressions.interfaces.IExpression;
import utilities.expressions.interfaces.INegateExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class NegateExpression extends AbstractUnaryExpression implements INegateExpression {

  public NegateExpression(IExpression child) {
    super(child);
  }
  
}
