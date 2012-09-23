/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.regexp.interfaces;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public interface IRegexpMatcher {

    IRegexpMatcher alpha();

    IRegexpMatcher numeric();

    IRegexpMatcher alphaNumeric();

    IRegexpMatcher space();

    IRegexpMatcher tab();

    IRegexpMatcher carriageReturn();

    IRegexpMatcher newLine();
}
