/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.templates;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class FileTemplate extends AbstractTemplate {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileTemplate.class);
    private File template;

    public FileTemplate(File file) {
        super();
        this.template = file;
    }

    public FileTemplate(File file, char placeholderBeginTag, char placeholderEndTag, String escapeCharacter) {
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

    public FileTemplate(String filePath, char placeholderBeginTag, char placeholderEndTag, String escapeCharacter) {
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
        renderTo(renderer);

        return renderBuilder.toString();
    }

    @Override
    protected Object getTemplate() {
        return template;
    }

    @Override
    public long getLength() {
        long templateLength = template.length();
        return correctTemplateLength(templateLength);
    }

    @Override
    protected void tryClose() {
        // nothing to do here
    }
}
