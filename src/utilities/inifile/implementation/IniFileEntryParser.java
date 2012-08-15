/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.inifile.implementation;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import utilities.inifile.interfaces.IIniFileEntry;
import utilities.inifile.interfaces.IIniFileEntryParser;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IniFileEntryParser implements IIniFileEntryParser {

  @Override
  public IIniFileEntry parse(InputStream inputStream) {
    IIniFileEntry entry = null;
    
    InputStreamReader isr = new InputStreamReader(inputStream);
    Scanner scanner = new Scanner(isr);
    
    return entry;
  }
  
}
