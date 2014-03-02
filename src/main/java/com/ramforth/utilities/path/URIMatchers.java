/* 
 * Copyright (C) 2014 Tobias Ramforth
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
