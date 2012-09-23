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
public class RegularExpressionFileFilter implements FileFilter {

    protected Pattern regularExpressionPattern;

    public RegularExpressionFileFilter(String regularExpression) {
        this.regularExpressionPattern = Pattern.compile(regularExpression);
    }

    public RegularExpressionFileFilter(Pattern regularExpressionPattern) {
        this.regularExpressionPattern = regularExpressionPattern;
    }

    @Override
    public boolean accept(File pathname) {
        return regularExpressionPattern.matcher(pathname.getName()).matches();
    }
}
