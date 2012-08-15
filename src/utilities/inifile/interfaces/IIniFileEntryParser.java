/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.inifile.interfaces;

import java.io.InputStream;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public interface IIniFileEntryParser {
    
  IIniFileEntry parse(InputStream inputStream);

}
