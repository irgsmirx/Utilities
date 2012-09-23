/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.path;

import java.io.FileFilter;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class FileFilters {

    public static FileFilter DIRECTORY = new DirectoryFileFilter();
    public static FileFilter FILE = new FileFileFilter();
}
