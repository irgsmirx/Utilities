/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.path;

import java.nio.file.Path;
import java.nio.file.PathMatcher;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class NegatingPathMatcher implements PathMatcher {
  
  private PathMatcher child;
  
  public NegatingPathMatcher(PathMatcher child) {
    this.child = child;
  }

  @Override
  public boolean matches(Path path) {
    return !child.matches(path);
  }
  
}
