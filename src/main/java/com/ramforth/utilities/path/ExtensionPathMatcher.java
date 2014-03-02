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
package com.ramforth.utilities.path;

import java.nio.file.Files;
import java.nio.file.PathMatcher;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class ExtensionPathMatcher implements PathMatcher {

    private String extension;

    public ExtensionPathMatcher(String extension) {
        if (extension.startsWith(".")) {
            this.extension = extension.substring(1).toLowerCase();
        } else {
            this.extension = extension.toLowerCase();
        }
    }

    @Override
    public boolean matches(java.nio.file.Path path) {
        return Files.isRegularFile(path) && path.getFileName().toString().toLowerCase().endsWith("." + extension);
    }
}
