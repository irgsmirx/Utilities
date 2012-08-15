/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.expressions.implementation;

import utilities.expressions.interfaces.IDivideExpression;
import utilities.expressions.interfaces.IExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class DivideExpression extends AbstractBinaryExpression implements IDivideExpression {

  public DivideExpression(IExpression leftChild, IExpression rightChild) {
    super(leftChild, rightChild);
  }
  
}