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
