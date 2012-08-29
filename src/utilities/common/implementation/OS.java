/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.common.implementation;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class OS {
  
  public static boolean isWindows() {
    return SystemProperties.getOperatingSystemName().toLowerCase().contains("windows");
  }
  
}
