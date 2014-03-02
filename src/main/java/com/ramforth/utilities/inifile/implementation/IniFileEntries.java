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
