/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.path;

import java.nio.file.Files;
import java.nio.file.PathMatcher;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class ExtensionPathMatcher implements PathMatcher {

  private String extension;
  
  public ExtensionPathMatcher(String extension) {
    if (extension.startsWith(".")) {
      this.extension = extension.substring(1);
    } else {
      this.extension = extension;
    }
  }
  
  @Override
  public boolean matches(java.nio.file.Path path) {
    return Files.isRegularFile(path) && path.getFileName().toString().toLowerCase().endsWith("." + extension);
  }
  
}
