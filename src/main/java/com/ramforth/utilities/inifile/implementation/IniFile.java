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

import com.ramforth.utilities.inifile.interfaces.IIniFile;
import com.ramforth.utilities.inifile.interfaces.IIniFileSection;
import com.ramforth.utilities.inifile.interfaces.IIniFileSections;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IniFile implements IIniFile {

    protected final IIniFileSection rootSection = new IniFileSection();
    protected final IIniFileSections sections = new IniFileSections();

    public IniFile() {
    }

    @Override
    public final IIniFileSection getRootSection() {
        return rootSection;
    }

    @Override
    public final IIniFileSections getSections() {
        return sections;
    }
}
