/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.inifile.interfaces;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public interface IIniFileEntries extends Iterable<IIniFileEntry> {
  
  void add(IIniFileEntry value);
  void remove(IIniFileEntry value);
  void remove(String value);
  void clear();
  boolean contains(IIniFileEntry value);
  boolean contains(String value);
  
}
