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
