/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.templates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class OldFileTemplate extends AbstractTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(OldFileTemplate.class);
    private File template;

    public OldFileTemplate(File file) {
        super();
        this.template = file;
    }

    public OldFileTemplate(File file, char placeholderBeginTag, char placeholderEndTag, String escapeCharacter) {
        super(placeholderBeginTag, placeholderEndTag, escapeCharacter);
        this.template = file;
    }

    public OldFileTemplate(String filePath) {
        super();
        this.template = new File(filePath);
    }

    public OldFileTemplate(String filePath, char placeholderBeginTag, char placeholderEndTag, String escapeCharacter) {
        super(placeholderBeginTag, placeholderEndTag, escapeCharacter);
        this.template = new File(filePath);
    }

    private InputStreamTemplate createInputStreamTemplate() {
        try {
            FileInputStream fileInputStream = new FileInputStream(template);
            InputStreamTemplate inputStreamTemplate = new InputStreamTemplate(fileInputStream);
            return inputStreamTemplate;
        }
        catch (FileNotFoundException ex) {
            LOGGER.warn("Error", ex); //TODO Enter precise error message
            throw new RuntimeException(ex);
        }
    }

    @Override
    public long renderTo(OutputStream outputStream) {
        return createInputStreamTemplate().renderTo(outputStream);
    }

    @Override
    public String render() {
        return createInputStreamTemplate().render();
    }

    @Override
    public long getLength() {
        return -1;
    }
}
