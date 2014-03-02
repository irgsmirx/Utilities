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
package com.ramforth.utilities.regexp.implementation;

import com.ramforth.utilities.regexp.interfaces.IRegexpMatcher;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class RegexpMatcher implements IRegexpMatcher {

    private String value;
    private int currentPosition = -1;

    public RegexpMatcher(String value) {
        this.value = value;
        int valueLength = value.length();
    }

    private int nextCharacter() {
        return value.codePointAt(currentPosition++);
    }

    @Override
    public IRegexpMatcher alpha() {
        if (!Character.isAlphabetic(nextCharacter())) {
            throw new RegexpDoesNotMatchException();
        }
        return this;
    }

    @Override
    public IRegexpMatcher numeric() {
        if (!Character.isDigit(nextCharacter())) {
            throw new RegexpDoesNotMatchException();
        }
        return this;
    }

    @Override
    public IRegexpMatcher alphaNumeric() {
        int nextCharacter = nextCharacter();

        if (!Character.isAlphabetic(nextCharacter) && !Character.isDigit(nextCharacter)) {
            throw new RegexpDoesNotMatchException();
        }
        return this;
    }

    @Override
    public IRegexpMatcher space() {
        if (!Character.isSpaceChar(nextCharacter())) {
            throw new RegexpDoesNotMatchException();
        }
        return this;
    }

    @Override
    public IRegexpMatcher tab() {
        return this;
    }

    @Override
    public IRegexpMatcher carriageReturn() {
        return this;
    }

    @Override
    public IRegexpMatcher newLine() {
        return this;
    }
}
