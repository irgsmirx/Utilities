package com.ramforth.utilities.triggering.implementation.conditions;

import com.ramforth.utilities.common.implementation.StringUtilities;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class FileExistsCondition extends AbstractPathCondition {

    @Override
    public boolean isMet() {
        return !StringUtilities.isNullOrEmpty(path) && Files.isRegularFile(Paths.get(path));
    }

    @Override
    public String toString() {
        return String.format("Die Datei \"%1s\" existiert", path);
    }

    @Override
    public String getFormatString() {
        return "Die Datei {path} existiert";
    }
}