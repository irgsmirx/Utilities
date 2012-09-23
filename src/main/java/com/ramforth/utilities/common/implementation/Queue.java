/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
