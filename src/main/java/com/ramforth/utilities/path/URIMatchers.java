/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.path;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class URIMatchers {

    public static final IURIMatcher DIRECTORY = new DirectoryURIMatcher();
    public static final IURIMatcher FILE = new FileURIMatcher();

    public static IURIMatcher extension(String extension) {
        return new ExtensionURIMatcher(extension);
    }

    public static IURIMatcher wildcard(String pattern) {
        return new WildcardURIMatcher(pattern);
    }

    public static IURIMatcher regularExpression(String pattern) {
        return new RegularExpressionURIMatcher(pattern);
    }

    public static ConjunctiveURIMatcher and(IURIMatcher... matchers) {
        return new ConjunctiveURIMatcher(matchers);
    }

    public static DisjunctiveURIMatcher or(IURIMatcher... matchers) {
        return new DisjunctiveURIMatcher(matchers);
    }

    public static NegatingURIMatcher not(IURIMatcher matcher) {
        return new NegatingURIMatcher(matcher);
    }
}
