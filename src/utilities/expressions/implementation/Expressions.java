/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.expressions.implementation;

import utilities.expressions.interfaces.*;

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
  
}
