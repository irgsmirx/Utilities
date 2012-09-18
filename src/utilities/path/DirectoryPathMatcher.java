/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.path;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.PathMatcher;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class DirectoryPathMatcher implements PathMatcher{

  private final LinkOption[] linkOptions;
  
  public DirectoryPathMatcher(LinkOption... linkOptions) {
    this.linkOptions = linkOptions;
  }

  public DirectoryPathMatcher() {
    this(new LinkOption[0]);
  }

  
  @Override
  public boolean matches(Path path) {
    return Files.isDirectory(path, linkOptions);
  }
  
}
