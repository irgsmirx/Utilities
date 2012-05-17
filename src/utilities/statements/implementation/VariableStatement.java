/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.statements.implementation;

import utilities.statements.interfaces.IVariableStatement;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class VariableStatement extends AbstractStatement implements IVariableStatement {
  
  protected String name;
  
  public VariableStatement(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String value) {
    this.name = name;
  }
  
  
  
}
