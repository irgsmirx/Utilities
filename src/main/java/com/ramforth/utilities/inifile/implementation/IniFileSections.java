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
import com.ramforth.utilities.inifile.interfaces.IIniFileSection;
import com.ramforth.utilities.inifile.interfaces.IIniFileSections;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IniFileSections implements IIniFileSections {

    protected final Map<String, IIniFileSection> sectionMap = new TreeMap<>();

    @Override
    public Iterator<IIniFileSection> iterator() {
        return sectionMap.values().iterator();
    }

    @Override
    public void add(IIniFileSection value) {
        sectionMap.put(value.getName(), value);
    }

    @Override
    public void remove(IIniFileSection value) {
        sectionMap.remove(value.getName());
    }

    @Override
    public void remove(String value) {
        sectionMap.remove(value);
    }

    @Override
    public void clear() {
        sectionMap.clear();
    }

    @Override
    public boolean contains(IIniFileSection value) {
        return sectionMap.containsKey(value.getName());
    }

    @Override
    public boolean contains(String value) {
        return sectionMap.containsKey(value);
    }
}
