/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.expressions.interfaces;

/**
 *
 * @author tobias
 */
public interface IUnaryExpression extends IExpression {
	
  IExpression getChild();
  void setChild(IExpression value);
  
}
