/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.expressions.implementation;

import utilities.expressions.interfaces.IExpression;
import utilities.expressions.interfaces.INorExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class NorExpression extends AbstractComparisonExpression implements INorExpression {

  public NorExpression(IExpression leftChild, IExpression rightChild) {
    super(leftChild, rightChild);
  }
  
}
