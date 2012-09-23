/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
