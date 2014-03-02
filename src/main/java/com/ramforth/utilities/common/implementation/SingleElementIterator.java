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

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author tobias
 */
public class SingleElementIterator<T> implements Iterator<T> {

    private T element;
    private boolean iterated = false;

    public SingleElementIterator(T element) {
        this.element = element;
    }

    @Override
    public boolean hasNext() {
        return !iterated;
    }

    @Override
    public T next() {
        if (iterated) {
            throw new NoSuchElementException();
        }

        iterated = true;

        return element;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported.");
    }
}
