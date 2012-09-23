/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.inifile.implementation;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import com.ramforth.utilities.inifile.interfaces.IIniFileSection;
import com.ramforth.utilities.inifile.interfaces.IIniFileSections;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IniFileSections implements IIniFileSections {

  protected final Map<String, IIniFileSection> sectionMap = new TreeMap<>();
  
  @Override
  public Iterator<IIniFileSection> iterator() {
    return sectionMap.values().iterator();
  }

  @Override
  public void add(IIniFileSection value) {
    sectionMap.put(value.getName(), value);
  }

  @Override
  public void remove(IIniFileSection value) {
    sectionMap.remove(value.getName());
  }

  @Override
  public void remove(String value) {
    sectionMap.remove(value);
  }

  @Override
  public void clear() {
    sectionMap.clear();
  }

  @Override
  public boolean contains(IIniFileSection value) {
    return sectionMap.containsKey(value.getName());
  }

  @Override
  public boolean contains(String value) {
    return sectionMap.containsKey(value);
  }
  
}
