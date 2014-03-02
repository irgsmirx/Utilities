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
package com.ramforth.utilities.common.implementation;

import com.ramforth.utilities.common.interfaces.INameValuePairs;
import com.ramforth.utilities.exceptions.NoSuchElementException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class NameValuePairs implements INameValuePairs {

    protected List<NameValuePair> pairs = new ArrayList<>();

    @Override
    public void add(NameValuePair value) {
        pairs.add(value);
    }

    @Override
    public void add(String name, String value) {
        pairs.add(new NameValuePair(name, value));
    }

    @Override
    public void remove(NameValuePair value) {
        pairs.remove(value);
    }

    @Override
    public void remove(String name) {
        Iterator<NameValuePair> iterator = pairs.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(name)) {
                iterator.remove();
            }
        }
    }

    @Override
    public int numberOfPairs() {
        return pairs.size();
    }

    @Override
    public void clear() {
        pairs.clear();
    }

    @Override
    public boolean contains(NameValuePair value) {
        return pairs.contains(value);
    }

    @Override
    public boolean contains(String name) {
        for (NameValuePair pair : pairs) {
            if (pair.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public NameValuePair get(String name) {
        for (NameValuePair pair : pairs) {
            if (pair.getName().equals(name)) {
                return pair;
            }
        }
        throw new NoSuchElementException("Name not found!");
    }
    
    @Override
    public NameValuePair getAt(int index) {
        return pairs.get(index);
    }

    @Override
    public String getValue(String name) {
        for (NameValuePair pair : pairs) {
            if (pair.getName().equals(name)) {
                return pair.getValue();
            }
        }
        throw new NoSuchElementException("Name not found!");
    }

    @Override
    public Iterator<NameValuePair> iterator() {
        return pairs.iterator();
    }
    
    @Override
    public void set(String name, String value) {
        boolean found = false;
        for (NameValuePair nameValuePair : pairs) {
            if (nameValuePair.getName().equals(name)) {
                nameValuePair.setValue(value);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new NoSuchElementException("Name not found!");
        }
    }
    
}
