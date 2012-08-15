/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.inifile.implementation;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import utilities.inifile.interfaces.IIniFileEntryParser;
import utilities.inifile.interfaces.IIniFileSection;
import utilities.inifile.interfaces.IIniFileSectionParser;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IniFileSectionParser implements IIniFileSectionParser {

  @Override
  public IIniFileSection parse(InputStream inputStream) {
    IIniFileSection section = null;
    
    InputStreamReader isr = new InputStreamReader(inputStream);
    Scanner scanner = new Scanner(isr);
    
    IIniFileEntryParser entryParser = new IniFileEntryParser();
    
    
    return section;
  }
  
}
