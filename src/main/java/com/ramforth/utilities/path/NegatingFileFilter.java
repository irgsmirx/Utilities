/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.path;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class NegatingFileFilter implements FileFilter {
  
  private FileFilter child;
  
  public NegatingFileFilter(FileFilter child) {
    this.child = child;
  }

  @Override
  public boolean accept(File pathname) {
    return !child.accept(pathname);
  }
  
}
