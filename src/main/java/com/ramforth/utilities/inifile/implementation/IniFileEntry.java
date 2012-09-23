/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.inifile.implementation;

import com.ramforth.utilities.inifile.interfaces.IIniFileEntry;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IniFileEntry implements IIniFileEntry {

  private String key;
  private String value;
  
  public IniFileEntry(String key, String value) {
    this.key = key;
    this.value = value;
  }
  
  @Override
  public String getKey() {
    return key;
  }

  @Override
  public void setKey(String value) {
    this.key = value;
  }

  @Override
  public String getValue() {
    return value;
  }

  @Override
  public void setValue(String value) {
    this.value = value;
  }
  
}
