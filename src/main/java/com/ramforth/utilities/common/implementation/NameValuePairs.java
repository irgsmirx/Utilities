/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.common.implementation;

import com.ramforth.utilities.common.interfaces.INameValuePairs;
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
        throw new RuntimeException("Name not found!");
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
            throw new RuntimeException("Name not found!");
        }
    }
    
}
