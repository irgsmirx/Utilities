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
import com.ramforth.utilities.common.interfaces.IPairs;
import com.ramforth.utilities.exceptions.NoSuchElementException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class Pairs<LEFT, RIGHT> implements IPairs<LEFT, RIGHT> {

    protected List<Pair<LEFT, RIGHT>> pairs = new ArrayList<>();

    @Override
    public void add(Pair<LEFT, RIGHT> value) {
        pairs.add(value);
    }

    @Override
    public void add(LEFT left, RIGHT right) {
        pairs.add(new Pair(left, right));
    }

    @Override
    public void remove(Pair<LEFT, RIGHT> value) {
        pairs.remove(value);
    }

    @Override
    public void remove(LEFT left) {
        Iterator<Pair<LEFT, RIGHT>> iterator = pairs.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getLeft().equals(left)) {
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
    public boolean contains(Pair<LEFT, RIGHT> value) {
        return pairs.contains(value);
    }

    @Override
    public boolean contains(LEFT left) {
        for (Pair<LEFT, RIGHT> pair : pairs) {
            if (pair.getLeft().equals(left)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Pair<LEFT, RIGHT> get(LEFT left) {
        for (Pair<LEFT, RIGHT> pair : pairs) {
            if (pair.getLeft().equals(left)) {
                return pair;
            }
        }
        throw new NoSuchElementException("Name not found!");
    }
    
    @Override
    public Pair<LEFT, RIGHT> getAt(int index) {
        return pairs.get(index);
    }

    @Override
    public RIGHT getRight(LEFT left) {
        for (Pair<LEFT, RIGHT> pair : pairs) {
            if (pair.getLeft().equals(left)) {
                return pair.getRight();
            }
        }
        throw new NoSuchElementException("LEFT not found!");
    }

    @Override
    public Iterator<Pair<LEFT, RIGHT>> iterator() {
        return pairs.iterator();
    }
    
    @Override
    public void set(LEFT left, RIGHT right) {
        boolean found = false;
        for (Pair<LEFT, RIGHT> pair : pairs) {
            if (pair.getLeft().equals(left)) {
                pair.setRight(right);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new NoSuchElementException("Name not found!");
        }
    }
    
}
