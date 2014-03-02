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
import com.ramforth.utilities.inifile.interfaces.IIniFileEntries;
import com.ramforth.utilities.inifile.interfaces.IIniFileEntry;
import com.ramforth.utilities.inifile.interfaces.IIniFileSection;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IniFileSection implements IIniFileSection {

    private String name;
    protected final IIniFileEntries entries = new IniFileEntries();

    public IniFileSection() {
    }

    public IniFileSection(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public final IIniFileEntries getEntries() {
        return entries;
    }

    @Override
    public final Iterator<IIniFileEntry> iterator() {
        return entries.iterator();
    }
}
