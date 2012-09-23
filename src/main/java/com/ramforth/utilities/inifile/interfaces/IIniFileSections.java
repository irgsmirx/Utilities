/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.inifile.interfaces;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public interface IIniFileSections extends Iterable<IIniFileSection> {
  
  void add(IIniFileSection value);
  void remove(IIniFileSection value);
  void remove(String value);
  void clear();
  boolean contains(IIniFileSection value);
  boolean contains(String value);
  
}
