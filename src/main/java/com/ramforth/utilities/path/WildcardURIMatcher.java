/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.path;

import java.net.URI;
import java.util.regex.Pattern;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class WildcardURIMatcher implements IURIMatcher {

    protected RegularExpressionURIMatcher innerURIMatcher;

    public WildcardURIMatcher(String wildcardExpression) {
        String regularExpressionPattern = wildcardExpression.replaceAll("\\?", ".").replaceAll("\\*|\\%", ".*").replaceAll("#", "[0-9]+");
        this.innerURIMatcher = new RegularExpressionURIMatcher(Pattern.compile(regularExpressionPattern, Pattern.CASE_INSENSITIVE));
    }

    @Override
    public boolean matches(URI uri) {
        return innerURIMatcher.matches(uri);
    }
}
