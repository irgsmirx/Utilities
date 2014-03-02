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
public class ArrayIterator<T> implements Iterator<T> {

    private T[] array;
    private int currentIndex = -1;
    private int maximumIndex;
    private boolean alreadyRemoved = true;

    public ArrayIterator(final T[] array) {
        this.array = array;
        this.maximumIndex = array.length - 1;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < maximumIndex;
    }

    @Override
    public T next() {
        if (currentIndex == maximumIndex) {
            throw new NoSuchElementException();
        }
        currentIndex++;
        alreadyRemoved = false;
        return array[currentIndex];
    }

    @Override
    public void remove() {
        if (currentIndex == -1) {
            throw new IllegalStateException("No element yet.");
        } else if (alreadyRemoved) {
            throw new IllegalStateException("Already removed.");
        }

        for (int i = currentIndex; i < maximumIndex; i++) {
            array[i] = array[i + 1];
            array[i + 1] = null;
        }
        alreadyRemoved = false;
    }
}
