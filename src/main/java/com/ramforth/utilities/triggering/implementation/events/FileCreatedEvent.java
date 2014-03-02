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
package com.ramforth.utilities.triggering.implementation.events;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class FileCreatedEvent extends AbstractPathEvent {

    //[NonSerialized]
    private boolean fileDidNotExistLastTime = false;

    @Override
    public boolean occurred() {
        boolean eventOccurred = false;

        Path filePath = Paths.get(path);

        if (fileDidNotExistLastTime) {
            if (Files.isRegularFile(filePath)) {
                eventOccurred = true;
                fileDidNotExistLastTime = false;
            }
        } else {
            if (Files.notExists(filePath)) {
                fileDidNotExistLastTime = true;
            }
        }

        return eventOccurred;
    }

    @Override
    public void reset() {
        fileDidNotExistLastTime = false;
    }

    @Override
    public String toString() {
        return String.format("Die Datei \"%1s\" wurde erstellt.", path);
    }

    @Override
    public String getFormatString() {
        return "Die Datei {path} wurde erstellt.";
    }
}
