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

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;
import com.ramforth.utilities.common.implementation.StringUtilities;
import com.ramforth.utilities.inifile.interfaces.IIniFile;
import com.ramforth.utilities.inifile.interfaces.IIniFileReader;
import com.ramforth.utilities.inifile.interfaces.IIniFileSection;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IniFileReader implements IIniFileReader {

    @Override
    public IIniFile parse(InputStream inputStream) {
        IIniFile file = new IniFile();

        Reader reader = new InputStreamReader(inputStream);
        Scanner scanner = new Scanner(reader);

        IIniFileSection currentSection = file.getRootSection();

        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            String nextLineTrimmed = nextLine.trim();

            if (nextLineTrimmed.startsWith("#")) {
                // skip
            } else if (nextLineTrimmed.startsWith("[") && nextLineTrimmed.endsWith("]")) {
                String sectionName = nextLineTrimmed.substring(1, nextLineTrimmed.length() - 1);
                currentSection = new IniFileSection(sectionName);
                file.getSections().add(currentSection);
            } else {
                int indexOfSeparator = nextLineTrimmed.indexOf("=");

                if (indexOfSeparator > -1) {
                    String key = nextLine.substring(0, indexOfSeparator);
                    String value;
                    if (indexOfSeparator < nextLineTrimmed.length()) {
                        value = nextLine.substring(indexOfSeparator + 1);
                    } else {
                        value = StringUtilities.EMPTY;
                    }
                    currentSection.getEntries().add(new IniFileEntry(key, value));
                }
            }
        }

        return file;
    }
}
