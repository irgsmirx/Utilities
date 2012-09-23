/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.path;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class RecursiveFileCollector {
    
  private File root;
  private FileFilter fileFilter;
  private List<File> files = new ArrayList<>();
  
  public RecursiveFileCollector(File root, FileFilter filter) {
    this.root = root;
    this.fileFilter = filter;
  }

  public void collect() {
    files.clear();
    searchRecursively(root, fileFilter);
  }
  
  public List<File> getFiles() {
    return files;
  }
  
  private void searchRecursively(File rootDirectory, FileFilter searchParametersFileFilter) {
    for (File subDirectory : rootDirectory.listFiles(FileFilters.DIRECTORY)) {
      searchRecursively(subDirectory, searchParametersFileFilter);
    }
    
    for (File mediaFile : rootDirectory.listFiles(searchParametersFileFilter)) {
      files.add(mediaFile);
    }
  }
  
  
}
