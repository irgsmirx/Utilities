/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.path;

import java.io.File;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class PathFileComparator extends AbstractFileComparator {

  @Override
  public int compare(File o1, File o2) {
    return o1.getPath().compareTo(o2.getPath());
  }
  
}
