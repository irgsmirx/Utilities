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

import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public abstract class AbstractMultiPathMatcher implements PathMatcher {

    protected final List<PathMatcher> matchers;

    public AbstractMultiPathMatcher() {
        this.matchers = new ArrayList<>();
    }

    public AbstractMultiPathMatcher(PathMatcher... matchers) {
        this();
        Collections.addAll(this.matchers, matchers);
    }

    public void addMatcher(PathMatcher value) {
        matchers.add(value);
    }

    public void removeMatcher(PathMatcher value) {
        matchers.remove(value);
    }

    public void clear() {
        matchers.clear();
    }
}
