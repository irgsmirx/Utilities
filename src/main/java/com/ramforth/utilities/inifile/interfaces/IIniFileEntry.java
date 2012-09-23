/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.inifile.interfaces;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public interface IIniFileEntry {
  
  String getKey();
  void setKey(String value);
  
  String getValue();
  void setValue(String value);
  
}
