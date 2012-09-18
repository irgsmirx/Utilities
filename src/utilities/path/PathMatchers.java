/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.path;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class PathMatchers {
  
  public static final PathMatcher DIRECTORY = new DirectoryPathMatcher();
  public static final PathMatcher FILE = new FilePathMatcher();
  
  public static PathMatcher extension(String extension) {
    if (extension.startsWith(".")) {
      return FileSystems.getDefault().getPathMatcher(String.format("glob:%s", extension.substring(1)));
    } else {
      return FileSystems.getDefault().getPathMatcher(String.format("glob:%s", extension));
    }
  }
  
  public static PathMatcher glob(String pattern) {
    return FileSystems.getDefault().getPathMatcher(String.format("glob:%s", pattern));
  }
  
  public static PathMatcher regularExpression(String pattern) {
    return FileSystems.getDefault().getPathMatcher(String.format("regex:%s", pattern));
  }
  
  public static ConjunctivePathMatcher and(PathMatcher... matchers) {
    return new ConjunctivePathMatcher(matchers);
  }

  public static DisjunctivePathMatcher or(PathMatcher... matchers) {
    return new DisjunctivePathMatcher(matchers);
  }

  public static NegatingPathMatcher not(PathMatcher matcher) {
    return new NegatingPathMatcher(matcher);
  }
  
}
