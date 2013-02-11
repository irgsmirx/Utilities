package com.ramforth.utilities.triggering.implementation.conditions;

import com.ramforth.utilities.common.implementation.StringUtilities;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class DirectoryExistsCondition extends AbstractPathCondition {

    @Override
    public boolean isMet() {
        return !StringUtilities.isNullOrEmpty(path) && Files.isDirectory(Paths.get(path));
    }

    @Override
    public String toString() {
        return String.format("Das Verzeichnis \"%1s\" existiert", path);
    }

    @Override
    public String getFormatString() {
        return "Das Verzeichnis {path} existiert.";
    }
}