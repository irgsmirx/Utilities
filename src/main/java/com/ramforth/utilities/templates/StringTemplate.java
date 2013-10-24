/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.templates;


import java.io.*;

/**
 *
 * @author ramforth
 */
public class StringTemplate extends AbstractTemplate {

    private final String template;

    public StringTemplate(String template) {
        super();
        this.template = template;
    }

    @Override
    protected Reader tryCreateReader() {
        return new BufferedReader(new StringReader(template));
    }

    @Override
    public String render() {
        StringBuilder renderBuilder = new StringBuilder();

        ICharRenderer renderer = new StringBuilderRenderer(renderBuilder);
        renderer.setCharset(this.charset);
        renderTo(renderer);

        return renderBuilder.toString();
    }

    @Override
    public long getLengthInBytes() {
        long templateLength = template.getBytes(charset).length;

        return correctTemplateLength(templateLength);
    }
    
    @Override
    public String getTemplate() {
        return template;
    }

    @Override
    protected void tryClose() {
        // nothing to do here
    }
}
