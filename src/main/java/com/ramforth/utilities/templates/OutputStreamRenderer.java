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
package com.ramforth.utilities.templates;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author tobias
 */
public class OutputStreamRenderer extends AbstractCharRenderer {

    private final OutputStream outputStream;

    public OutputStreamRenderer(OutputStream os) {
        this.outputStream = os;
    }

    @Override
    public void render(int codePoint) {
        try {
            for (char c : Character.toChars(codePoint)) {
                outputStream.write(c);
            }
        }
        catch (IOException ioex) {
            LOGGER.warn("Error rendering character to outputstream", ioex);
            throw new com.ramforth.utilities.exceptions.IOException(ioex);
        }
    }

    @Override
    public void render(String s) {
        try {
            outputStream.write(s.getBytes(charset));
        }
        catch (IOException ioex) {
            LOGGER.warn("Error rendering string to outputstream", ioex);
            throw new com.ramforth.utilities.exceptions.IOException(ioex);
        }
    }

    @Override
    public void render(Object o) {
        render(String.valueOf(o));
    }
}
