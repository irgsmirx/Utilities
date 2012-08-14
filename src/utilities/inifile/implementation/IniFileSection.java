/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.inifile.implementation;

import java.util.Iterator;
import utilities.inifile.interfaces.IIniFileEntries;
import utilities.inifile.interfaces.IIniFileEntry;
import utilities.inifile.interfaces.IIniFileSection;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IniFileSection implements IIniFileSection {

  @Override
  public IIniFileEntries getEntries() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public Iterator<IIniFileEntry> iterator() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
}
