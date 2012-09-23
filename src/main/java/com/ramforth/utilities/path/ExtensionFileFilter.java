/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.path;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class ExtensionFileFilter implements FileFilter {

    private String extension;

    public ExtensionFileFilter(String extension) {
        if (extension.startsWith(".")) {
            this.extension = extension.substring(1);
        } else {
            this.extension = extension;
        }
    }

    @Override
    public boolean accept(File pathname) {
        return pathname.isFile() && pathname.getName().toLowerCase().endsWith("." + extension);
    }
}
