/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.inifile.implementation;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import com.ramforth.utilities.inifile.interfaces.IIniFileEntries;
import com.ramforth.utilities.inifile.interfaces.IIniFileEntry;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IniFileEntries implements IIniFileEntries {

    protected final Map<String, IIniFileEntry> entryMap = new TreeMap<>();

    @Override
    public Iterator<IIniFileEntry> iterator() {
        return entryMap.values().iterator();
    }

    @Override
    public void add(IIniFileEntry value) {
        entryMap.put(value.getKey(), value);
    }

    @Override
    public void remove(IIniFileEntry value) {
        entryMap.remove(value.getKey());
    }

    @Override
    public void remove(String value) {
        entryMap.remove(value);
    }

    @Override
    public void clear() {
        entryMap.clear();
    }

    @Override
    public boolean contains(IIniFileEntry value) {
        return entryMap.containsKey(value.getKey());
    }

    @Override
    public boolean contains(String value) {
        return entryMap.containsKey(value);
    }
}
