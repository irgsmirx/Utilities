/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.path;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public abstract class MultiFileFilter implements FileFilter {

  protected List<FileFilter> filters = new ArrayList<>();
  
  public void addFilter(FileFilter value) {
    filters.add(value);
  }
  
  public void removeFilter(FileFilter value) {
    filters.remove(value);
  }
  
  public void clear() {
    filters.clear();
  }
  
}
