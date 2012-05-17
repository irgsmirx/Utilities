/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.statements.implementation;

import utilities.statements.interfaces.IBlockStatement;
import utilities.statements.interfaces.IStatement;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class BlockStatement extends AbstractStatement implements IBlockStatement {

  protected IStatement[] statements;
  
  public BlockStatement(IStatement... statements) {
    this.statements = statements;
  }
  
  @Override
  public IStatement[] getStatements() {
    return statements;
  }

  @Override
  public void setStatements(IStatement... value) {
    this.statements = value;
  }
  
}
