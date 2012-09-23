/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.path;

import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class RegularExpressionPathMatcher implements PathMatcher {

    protected Pattern regularExpressionPattern;

    public RegularExpressionPathMatcher(String regularExpression) {
        this.regularExpressionPattern = Pattern.compile(regularExpression);
    }

    public RegularExpressionPathMatcher(Pattern regularExpressionPattern) {
        this.regularExpressionPattern = regularExpressionPattern;
    }

    @Override
    public boolean matches(Path path) {
        return regularExpressionPattern.matcher(path.toString()).matches();
    }
}
