/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.path;

import java.net.URI;
import java.nio.file.Path;
import java.util.regex.Pattern;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class RegularExpressionURIMatcher implements IURIMatcher {

    protected Pattern regularExpressionPattern;

    public RegularExpressionURIMatcher(String regularExpression) {
        this.regularExpressionPattern = Pattern.compile(regularExpression);
    }

    public RegularExpressionURIMatcher(Pattern regularExpressionPattern) {
        this.regularExpressionPattern = regularExpressionPattern;
    }

    @Override
    public boolean matches(URI uri) {
        return regularExpressionPattern.matcher(uri.toString()).matches();
    }
}
