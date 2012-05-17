/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.expressions.implementation;

import utilities.expressions.interfaces.IExpression;
import utilities.expressions.interfaces.IPropertyExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class PropertyExpression extends AbstractExpression implements IPropertyExpression {
  
  private IExpression target;
  private String propertyName;

  public PropertyExpression(IExpression target, String propertyName) {
    this.target = target;
    this.propertyName = propertyName;
  }

  @Override
  public IExpression getTarget() {
    return target;
  }

  @Override
  public void setTarget(IExpression value) {
    this.target = value;
  }

  @Override
  public String getPropertyName() {
    return propertyName;
  }

  @Override
  public void setPropertyName(String value) {
    this.propertyName = value;
  }
  
}
