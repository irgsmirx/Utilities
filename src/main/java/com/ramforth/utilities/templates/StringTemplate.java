/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.templates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ramforth
 */
public class StringTemplate extends AbstractTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringTemplate.class);
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
    protected String getTemplate() {
        return template;
    }

    @Override
    protected void tryClose() {
        // nothing to do here
    }
}
