/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.path;

import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class WildcardPathMatcher implements PathMatcher {

  protected RegularExpressionPathMatcher innerPathMatcher;
  
  public WildcardPathMatcher(String wildcardExpression) {
    String regularExpressionPattern = wildcardExpression.replaceAll("\\?", ".").replaceAll("\\*|\\%", ".*").replaceAll("#", "[0-9]+");
    this.innerPathMatcher = new RegularExpressionPathMatcher(Pattern.compile(regularExpressionPattern, Pattern.CASE_INSENSITIVE));
  }
  
  @Override
  public boolean matches(Path path) {
    return innerPathMatcher.matches(path);
  }
  
}
