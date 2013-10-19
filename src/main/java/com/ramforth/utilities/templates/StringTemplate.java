/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.templates;


import java.io.*;
import java.nio.charset.Charset;

/**
 *
 * @author ramforth
 */
public class StringTemplate extends AbstractTemplate {

    private String template;

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
        renderTo(renderer);

        return renderBuilder.toString();
    }

    @Override
    public long getLength() {
        long templateLength = template.getBytes().length;

        return correctTemplateLength(templateLength);
    }

    @Override
    public long getLength(Charset charset) {
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
