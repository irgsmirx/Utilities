/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.expressions.interfaces;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public interface IPropertyExpression {
  
  IExpression getTarget();
  void setTarget(IExpression value);
  
  String getPropertyName();
  void setPropertyName(String value);
  
}
