package com.ramforth.utilities.triggering.implementation.events;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class DirectoryCreatedEvent extends AbstractPathEvent {

    //[NonSerialized]
    private boolean directoryDidNotExistLastTime = false;

    @Override
    public boolean occurred() {
        boolean eventOccurred = false;

        Path directoryPath = Paths.get(path);

        if (directoryDidNotExistLastTime) {
            if (Files.isDirectory(directoryPath)) {
                eventOccurred = true;
                directoryDidNotExistLastTime = false;
            }
        } else {
            if (Files.notExists(directoryPath)) {
                directoryDidNotExistLastTime = true;
            }
        }

        return eventOccurred;
    }

    @Override
    public void reset() {
        directoryDidNotExistLastTime = false;
    }

    @Override
    public String toString() {
        return String.format("Das Verzeichnis \"%1s\" wurde erstellt.", path);
    }

    @Override
    public String getFormatString() {
        return "Das Verzeichnis {path} wurde erstellt.";
    }
}
