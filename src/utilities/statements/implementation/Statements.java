/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.statements.implementation;

import utilities.expressions.interfaces.IExpression;
import utilities.expressions.interfaces.IParameterExpression;
import utilities.statements.interfaces.*;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class Statements {
  
  public static IAssignmentStatement Assignment() {
    return new AssignmentStatement();
  }
  
  public static IIncrementStatement Increment(IParameterExpression target) {
    return new IncrementStatement(target);
  }
  
  public static IDecrementStatement Increment(IParameterExpression target) {
    return new DecrementStatement(target);
  }
  
  public static IVariableStatement Variable(String name) {
    return new VariableStatement(name);
  }
  
  public static IBlockStatement Block(IStatement... statements) {
    return new BlockStatement(statements);
  }

  public static IIfStatement If(IExpression condition, IStatement thenStatement) {
    return new IfStatement(condition, thenStatement);
  }
  
  public static IIfStatement If(IExpression condition, IStatement thenStatement, IStatement elseStatement) {
    return new IfStatement(condition, thenStatement, elseStatement);
  }
  
}
