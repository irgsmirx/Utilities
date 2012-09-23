/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.path;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class WildcardFileFilter implements FileFilter {

  protected RegularExpressionFileFilter innerFileFilter;
  
  public WildcardFileFilter(String wildcardExpression) {
    String regularExpressionPattern = wildcardExpression.replaceAll("\\?", ".").replaceAll("\\*|\\%", ".*").replaceAll("#", "[0-9]+");
    this.innerFileFilter = new RegularExpressionFileFilter(Pattern.compile(regularExpressionPattern, Pattern.CASE_INSENSITIVE));
  }
  
  @Override
  public boolean accept(File pathname) {
    return innerFileFilter.accept(pathname);
  }
  
}
