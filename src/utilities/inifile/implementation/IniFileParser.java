/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.inifile.implementation;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import utilities.inifile.interfaces.IIniFile;
import utilities.inifile.interfaces.IIniFileParser;
import utilities.inifile.interfaces.IIniFileSectionParser;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IniFileParser implements IIniFileParser {

  @Override
  public IIniFile parse(InputStream inputStream) {
    IIniFile file = new IniFile();
    
    InputStreamReader isr = new InputStreamReader(inputStream);
    Scanner scanner = new Scanner(isr);
    
    IIniFileSectionParser sectionParser = new IniFileSectionParser();
    
    while (scanner.hasNextLine()) {
      
    }
    
    return file;
  }
  
}
