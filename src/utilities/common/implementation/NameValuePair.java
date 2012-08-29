/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.common.implementation;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class NameValuePair extends Pair<String, String> {
  
  public NameValuePair(String name, String value) {
    super(name, value);
  }
  
  public String getName() {
    return getLeft();
  }
  
  public void setName(String value) {
    setLeft(value);
  }

  public String getValue() {
    return getRight();
  }
  
  public void setValue(String value) {
    setRight(value);
  }
  
}
