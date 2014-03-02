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
