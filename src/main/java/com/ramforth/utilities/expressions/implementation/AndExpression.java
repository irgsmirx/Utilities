/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.expressions.implementation;

import com.ramforth.utilities.expressions.interfaces.IAndExpression;
import com.ramforth.utilities.expressions.interfaces.IExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class AndExpression extends AbstractConditionalExpression implements IAndExpression {

  public AndExpression(IExpression leftChild, IExpression rightChild) {
    super(leftChild, rightChild);
  }
  
}
