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
package com.ramforth.utilities.common.interfaces;

import com.ramforth.utilities.common.implementation.NameValuePair;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public interface INameValuePairs extends Iterable<NameValuePair> {

    void add(NameValuePair value);

    void add(String name, String value);

    void remove(NameValuePair value);

    void remove(String name);

    int numberOfPairs();

    void clear();

    boolean contains(NameValuePair value);

    boolean contains(String name);

    NameValuePair get(String name);
    
    NameValuePair getAt(int index);

    String getValue(String name);
    
    void set(String name, String value);
    
}
