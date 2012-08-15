/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.expressions.implementation;

import utilities.expressions.interfaces.IModuloExpression;
import utilities.expressions.interfaces.IExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class ModuloExpression extends AbstractBinaryExpression implements IModuloExpression {

  public ModuloExpression(IExpression leftChild, IExpression rightChild) {
    super(leftChild, rightChild);
  }
  
}