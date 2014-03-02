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
public class PathMatchers {

    public static final PathMatcher DIRECTORY = new DirectoryPathMatcher();
    public static final PathMatcher FILE = new FilePathMatcher();

    public static PathMatcher extension(String extension) {
        return new ExtensionPathMatcher(extension);
    }

    public static PathMatcher glob(String pattern) {
        return FileSystems.getDefault().getPathMatcher(String.format("glob:%s", pattern));
    }

    public static PathMatcher regularExpression(String pattern) {
        return FileSystems.getDefault().getPathMatcher(String.format("regex:%s", pattern));
    }

    public static ConjunctivePathMatcher and(PathMatcher... matchers) {
        return new ConjunctivePathMatcher(matchers);
    }

    public static DisjunctivePathMatcher or(PathMatcher... matchers) {
        return new DisjunctivePathMatcher(matchers);
    }

    public static NegatingPathMatcher not(PathMatcher matcher) {
        return new NegatingPathMatcher(matcher);
    }
}
