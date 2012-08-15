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

  protected final IIniFileSection rootSection = new IniFileSection();
  protected final IIniFileSections sections = new IniFileSections();
  
  public IniFile() {
  }
  
  @Override
  public final IIniFileSection getRootSection() {
    return rootSection;
  }

  @Override
  public final IIniFileSections getSections() {
    return sections;
  }
  
}
