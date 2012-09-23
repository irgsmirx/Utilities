/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.expressions.implementation;

import com.ramforth.utilities.expressions.interfaces.IExpression;
import com.ramforth.utilities.expressions.interfaces.IPowerExpression;
import com.ramforth.utilities.expressions.interfaces.IAddExpression;
import com.ramforth.utilities.expressions.interfaces.IGreaterOrEqualExpression;
import com.ramforth.utilities.expressions.interfaces.ISubtractExpression;
import com.ramforth.utilities.expressions.interfaces.IAndExpression;
import com.ramforth.utilities.expressions.interfaces.IModuloExpression;
import com.ramforth.utilities.expressions.interfaces.IMultiplyExpression;
import com.ramforth.utilities.expressions.interfaces.IPropertyExpression;
import com.ramforth.utilities.expressions.interfaces.IOrExpression;
import com.ramforth.utilities.expressions.interfaces.ILessOrEqualExpression;
import com.ramforth.utilities.expressions.interfaces.INotExpression;
import com.ramforth.utilities.expressions.interfaces.INorExpression;
import com.ramforth.utilities.expressions.interfaces.ILessThanExpression;
import com.ramforth.utilities.expressions.interfaces.IDivideExpression;
import com.ramforth.utilities.expressions.interfaces.IXorExpression;
import com.ramforth.utilities.expressions.interfaces.IParenthesizedExpression;
import com.ramforth.utilities.expressions.interfaces.IEqualExpression;
import com.ramforth.utilities.expressions.interfaces.IGreaterThanExpression;
import com.ramforth.utilities.expressions.interfaces.INegateExpression;
import com.ramforth.utilities.expressions.interfaces.IConstantExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class Expressions {
  
  public static IAndExpression And(IExpression left, IExpression right) {
    return new AndExpression(left, right);
  }
  
  public static IOrExpression Or(IExpression left, IExpression right) {
    return new OrExpression(left, right);
  }

  public static INorExpression Nor(IExpression left, IExpression right) {
    return new NorExpression(left, right);
  }
  
  public static IXorExpression Xor(IExpression left, IExpression right) {
    return new XorExpression(left, right);
  }
  
  public static INotExpression Not(IExpression child) {
    return new NotExpression(child);
  }
  

  public static INegateExpression Negate(IExpression child) {
    return new NegateExpression(child);
  }
  
  public static IAddExpression Add(IExpression left, IExpression right) {
    return new AddExpression(left, right);
  }
  
  public static ISubtractExpression Subtract(IExpression left, IExpression right) {
    return new SubtractExpression(left, right);
  }
  
  public static IDivideExpression Divide(IExpression left, IExpression right) {
    return new DivideExpression(left, right);
  }
  
  public static IMultiplyExpression Multiply(IExpression left, IExpression right) {
    return new MultiplyExpression(left, right);
  }
  
  public static IModuloExpression Modulo(IExpression left, IExpression right) {
    return new ModuloExpression(left, right);
  }
  
  public static IPowerExpression Power(IExpression left, IExpression right) {
    return new PowerExpression(left, right);
  }
  
  
  public static IParenthesizedExpression Parenthesized(IExpression child) {
    return new ParenthesizedExpression(child);
  }
  
  
  
  public static IPropertyExpression Property(IExpression target, String propertyName) {
    return new PropertyExpression(target, propertyName);
  }
  
  
  
  public static IEqualExpression Equal(IExpression left, IExpression right) {
    return new EqualExpression(left, right);
  }
  
  public static ILessThanExpression LessThan(IExpression left, IExpression right) {
    return new LessThanExpression(left, right);
  }
    
  public static ILessOrEqualExpression LessOrEqual(IExpression left, IExpression right) {
    return new LessOrEqualExpression(left, right);
  }

  public static IGreaterThanExpression GreaterThan(IExpression left, IExpression right) {
    return new GreaterThanExpression(left, right);
  }

  public static IGreaterOrEqualExpression GreaterOrEqual(IExpression left, IExpression right) {
    return new GreaterOrEqualExpression(left, right);
  }

  
	public static IConstantExpression Constant(Object value) {
		return new ConstantExpression(value);
	}
	
}
