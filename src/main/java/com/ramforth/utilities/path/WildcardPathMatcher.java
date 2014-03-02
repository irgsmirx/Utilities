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

import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class WildcardPathMatcher implements PathMatcher {

    protected RegularExpressionPathMatcher innerPathMatcher;

    public WildcardPathMatcher(String wildcardExpression) {
        String regularExpressionPattern = wildcardExpression.replaceAll("\\?", ".").replaceAll("\\*|\\%", ".*").replaceAll("#", "[0-9]+");
        this.innerPathMatcher = new RegularExpressionPathMatcher(Pattern.compile(regularExpressionPattern, Pattern.CASE_INSENSITIVE));
    }

    @Override
    public boolean matches(Path path) {
        return innerPathMatcher.matches(path);
    }
}
