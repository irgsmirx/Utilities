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

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import com.ramforth.utilities.inifile.interfaces.IIniFile;
import com.ramforth.utilities.inifile.interfaces.IIniFileEntries;
import com.ramforth.utilities.inifile.interfaces.IIniFileEntry;
import com.ramforth.utilities.inifile.interfaces.IIniFileSection;
import com.ramforth.utilities.inifile.interfaces.IIniFileSections;
import com.ramforth.utilities.inifile.interfaces.IIniFileWriter;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IniFileWriter implements IIniFileWriter {

    private OutputStream outputStream;
    private boolean closeStreamWhenDone = true;

    public IniFileWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void write(IIniFile iniFile) {
        PrintWriter printWriter = new PrintWriter(outputStream, true);

        writeSection(printWriter, iniFile.getRootSection());
        writeSections(printWriter, iniFile.getSections());

        try {
            outputStream.flush();
            if (closeStreamWhenDone) {
                outputStream.close();
            }
        }
        catch (IOException ioex) {
            throw new com.ramforth.utilities.exceptions.IOException(ioex);
        }
    }

    public void setCloseStreamWhenDone(boolean value) {
        this.closeStreamWhenDone = value;
    }

    public boolean isCloseStreamWhenDone() {
        return closeStreamWhenDone;
    }

    private void writeSections(PrintWriter printWriter, IIniFileSections sections) {
        for (IIniFileSection section : sections) {
            printWriter.println();
            writeSection(printWriter, section);
        }
    }

    private void writeSection(PrintWriter printWriter, IIniFileSection section) {
        if (section.getName() != null) {
            writeSectionName(printWriter, section.getName());
            writeSectionEntries(printWriter, section.getEntries());
        }
    }

    private void writeSectionName(PrintWriter printWriter, String name) {
        printWriter.print('[');
        printWriter.print(name);
        printWriter.println(']');
    }

    private void writeSectionEntries(PrintWriter printWriter, IIniFileEntries entries) {
        for (IIniFileEntry entry : entries) {
            writeEntry(printWriter, entry);
        }
    }

    private void writeEntry(PrintWriter printWriter, IIniFileEntry entry) {
        printWriter.print(entry.getKey());
        printWriter.print('=');
        printWriter.println(entry.getValue());
    }
}
