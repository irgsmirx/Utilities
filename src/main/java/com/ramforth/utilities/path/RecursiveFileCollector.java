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

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class RecursiveFileCollector {

    private File root;
    private FileFilter fileFilter;
    private List<File> files = new ArrayList<>();

    public RecursiveFileCollector(File root, FileFilter filter) {
        this.root = root;
        this.fileFilter = filter;
    }

    public void collect() {
        files.clear();
        searchRecursively(root, fileFilter);
    }

    public List<File> getFiles() {
        return files;
    }

    private void searchRecursively(File rootDirectory, FileFilter searchParametersFileFilter) {
        for (File subDirectory : rootDirectory.listFiles(FileFilters.DIRECTORY)) {
            searchRecursively(subDirectory, searchParametersFileFilter);
        }

        Collections.addAll(files, rootDirectory.listFiles(searchParametersFileFilter));
    }
}
