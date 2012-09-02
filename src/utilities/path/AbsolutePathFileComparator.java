/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.path;

import java.io.File;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class AbsolutePathFileComparator extends AbstractFileComparator {

  @Override
  public int compare(File o1, File o2) {
    return o1.getAbsolutePath().compareTo(o2.getAbsolutePath());
  }
  
}
