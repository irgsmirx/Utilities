/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.constraints;

import java.util.regex.Pattern;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class RegularExpressionStringConstraint extends AbstractStringConstraint {
    
    private Pattern regularExpressionPattern;
    
    public RegularExpressionStringConstraint(String regularExpression) {
        this.regularExpressionPattern = Pattern.compile(regularExpression);
    }
    
    public RegularExpressionStringConstraint(Pattern regularExpressionPattern) {
        this.regularExpressionPattern = regularExpressionPattern;
    }

    @Override
    public boolean isSatisfied(String value) {
        return regularExpressionPattern.matcher(value).matches();
    }
    
}
