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
public class ConjunctiveFileFilter extends AbstractMultiFileFilter {

    @Override
    public boolean accept(File pathname) {
        for (FileFilter filter : filters) {
            if (!filter.accept(pathname)) {
                return false;
            }
        }
        return true;
    }
}
