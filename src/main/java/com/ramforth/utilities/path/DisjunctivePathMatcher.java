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
public class DisjunctivePathMatcher extends AbstractMultiPathMatcher {

  public DisjunctivePathMatcher() {
    super();
  }
  
  public DisjunctivePathMatcher(PathMatcher... matchers) {
    super(matchers);
  }
  
  @Override
  public boolean matches(Path path) {
    for (PathMatcher matcher : matchers) {
      if (matcher.matches(path)) {
        return true;
      }
    }
    return false;
  }
  
}
