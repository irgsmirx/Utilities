/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.templates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * @author tobias
 */
public class OutputStreamRenderer extends AbstractCharRenderer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OutputStreamRenderer.class);
    private OutputStream outputStream;

    public OutputStreamRenderer(OutputStream os) {
        this.outputStream = os;
    }

    @Override
    public void render(char c) {
        try {
            outputStream.write(c);
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
