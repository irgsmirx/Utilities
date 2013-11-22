/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.templates;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class FileTemplate extends AbstractTemplate {

    private File template;

    public FileTemplate(File file) {
        super();
        this.template = file;
    }

    public FileTemplate(File file, String placeholderBeginTag, String placeholderEndTag, String escapeCharacter) {
        super(placeholderBeginTag, placeholderEndTag, escapeCharacter);
        this.template = file;
    }

    public FileTemplate(String filePath) {
        super();
        URL url = this.getClass().getClassLoader().getResource(filePath);
        try {
                if (url != null) {
                        this.template = new File(url.toURI());
                }
                else {
                        throw new IllegalArgumentException("Unable to find file " + filePath);
                }
        }
        catch (URISyntaxException e) {
                throw new com.ramforth.utilities.exceptions.URISyntaxException(e);
        }
    }

    public FileTemplate(String filePath, String placeholderBeginTag, String placeholderEndTag, String escapeCharacter) {
        super(placeholderBeginTag, placeholderEndTag, escapeCharacter);
        this.template = new File(filePath);
    }

    @Override
    protected Reader tryCreateReader() {
        try {
            return new BufferedReader(new InputStreamReader(new FileInputStream(template)));
        }
        catch (FileNotFoundException fnfex) {
            LOGGER.warn("Error", fnfex); //TODO Enter precise error message
            throw new com.ramforth.utilities.exceptions.FileNotFoundException(fnfex);
        }
    }

    @Override
    public String render() {
        StringBuilder renderBuilder = new StringBuilder();

        ICharRenderer renderer = new StringBuilderRenderer(renderBuilder);
        renderer.setCharset(charset);
        renderTo(renderer);

        return renderBuilder.toString();
    }

    @Override
    public Object getTemplate() {
        return template;
    }

    @Override
    public long getLengthInBytes() {
        long templateLength = template.length();
        return correctTemplateLength(templateLength);
    }
    
    @Override
    protected void tryClose() {
        // nothing to do here
    }
}
