/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ramforth.utilities.common.implementation;

import java.util.Iterator;

/**
 *
 * @author Tobias Ramforth
 * @param <T>
 */
public class IteratorIterable<T> implements Iterable<T> {
    
    private final Iterator<T> iterator;
    
    public IteratorIterable(Iterator<T> value) {
        this.iterator = value;
    }

    @Override
    public Iterator<T> iterator() {
        return iterator;
    }
    
    
    
}
