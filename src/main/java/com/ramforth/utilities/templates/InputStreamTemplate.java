/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.templates;

import java.io.*;
import java.nio.charset.Charset;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class InputStreamTemplate extends AbstractTemplate {

    protected InputStream template;

    public InputStreamTemplate(InputStream inputStream) {
        super();
        this.template = inputStream;
    }

    @Override
    protected Reader tryCreateReader() {
        return new BufferedReader(new InputStreamReader(template, charset));
    }
    
    @Override
    protected void tryClose() {
        try {
            this.template.close();
        } catch (IOException ioex) {
            LOGGER.warn("Error closing template!", ioex);
            throw new com.ramforth.utilities.exceptions.IOException(ioex);
        }
    }

    @Override
    public String render() {
        StringBuilder renderBuilder = new StringBuilder();

        ICharRenderer renderer = new StringBuilderRenderer(renderBuilder);
        renderTo(renderer);

        return renderBuilder.toString();
    }

    @Override
    public long getLengthInBytes() {
        long templateLength = 0;
        try {
            templateLength = template.available();
        }
        catch (IOException ex) {
            return -1;
        }
        
        return correctTemplateLength(templateLength);
    }
    
    @Override
    public Object getTemplate() {
        return template;
    }
    
}

