/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.path;

import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public abstract class AbstractMultiPathMatcher implements PathMatcher {

  protected final List<PathMatcher> matchers;
  
  public AbstractMultiPathMatcher() {
    this.matchers = new ArrayList<>();
  }
  
  public AbstractMultiPathMatcher(PathMatcher... matchers) {
    this();
    for (PathMatcher matcher : matchers) {
      this.matchers.add(matcher);
    }
  }
   
  public void addMatcher(PathMatcher value) {
    matchers.add(value);
  }
  
  public void removeMatcher(PathMatcher value) {
    matchers.remove(value);
  }
  
  public void clear() {
    matchers.clear();
  }  
}
