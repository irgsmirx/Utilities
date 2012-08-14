/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.inifile.implementation;

import utilities.inifile.interfaces.IIniFile;
import utilities.inifile.interfaces.IIniFileSection;
import utilities.inifile.interfaces.IIniFileSections;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IniFile implements IIniFile {

  @Override
  public IIniFileSection getRootSection() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public IIniFileSections getSections() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
}
