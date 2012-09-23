/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.inifile.implementation;

import java.util.Iterator;
import com.ramforth.utilities.inifile.interfaces.IIniFileEntries;
import com.ramforth.utilities.inifile.interfaces.IIniFileEntry;
import com.ramforth.utilities.inifile.interfaces.IIniFileSection;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IniFileSection implements IIniFileSection {

  private String name;
  protected final IIniFileEntries entries = new IniFileEntries();
  
  public IniFileSection() {
  }

  public IniFileSection(String name) {
    this.name = name;
  }
  
  @Override
  public String getName() {
    return name;
  }
  
  @Override
  public void setName(String value) {
    this.name = value;
  }
  
  @Override
  public final IIniFileEntries getEntries() {
    return entries;
  }

  @Override
  public final Iterator<IIniFileEntry> iterator() {
    return entries.iterator();
  }
  
}
