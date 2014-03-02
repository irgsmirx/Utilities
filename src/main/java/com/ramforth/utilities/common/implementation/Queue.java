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

import com.ramforth.utilities.common.interfaces.IQueue;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class Queue<T> implements IQueue<T> {

    private T[] elements;
    private int numberOfElements = 0;
    private int indexOfFirstElement = 0;

    public Queue() {
        elements = (T[]) new Object[2];
    }

    @Override
    public int getLength() {
        return elements.length;
    }

    @Override
    public int numberOfElements() {
        return numberOfElements;
    }

    @Override
    public void enqueue(T value) {
        if (numberOfElements == elements.length) {
            T[] newElements = (T[]) new Object[elements.length + 1];

            for (int i = 0; i < getLength(); i++) {
                newElements[i] = getAt(i);
            }

            elements = newElements;
            indexOfFirstElement = 0;
        }

        elements[( indexOfFirstElement + numberOfElements ) % getLength()] = value;
        numberOfElements++;
    }

    @Override
    public T dequeue() {
        if (numberOfElements == 0) {
            throw new QueueException();
        } else {
            T element = getAt(0);
            indexOfFirstElement = ( indexOfFirstElement + 1 ) % getLength();
            numberOfElements--;
            return element;
        }
    }

    @Override
    public void clear() {
        numberOfElements = 0;
        indexOfFirstElement = 0;
    }

    @Override
    public T getAt(int index) {
        return elements[( indexOfFirstElement + index ) % getLength()];
    }
}
