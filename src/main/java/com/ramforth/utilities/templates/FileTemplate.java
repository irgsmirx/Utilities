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

    private Reader tryCreateReader() {
        try {
            return new BufferedReader(new InputStreamReader(new FileInputStream(template)));
        }
        catch (FileNotFoundException fnfex) {
            LOGGER.warn("Error", fnfex); //TODO Enter precise error message
            throw new com.ramforth.utilities.exceptions.FileNotFoundException(fnfex);
        }
    }
    
    private long renderTo(ICharRenderer renderer) {
        long length = 0;
        if (template != null) {
            StringBuilder sb = new StringBuilder();

            boolean inPlaceholder = false;
            boolean inIndexer = false;

            Field currentField = null;
            String currentPlaceholderKey = null;
            Object currentValue = null;

            try (Reader reader = tryCreateReader()) {
                int templateCharacter;
                try {
                    while (( templateCharacter = reader.read() ) != -1) {
                        if (templateCharacter == placeholderBeginTag) {
                            if (inPlaceholder) {
                                sb.append((char) templateCharacter);
                            } else {
                                inPlaceholder = true;
                            }
                        } else if (templateCharacter == placeholderEndTag) {
                            if (sb.length() > 0) {
                                String propertyName = sb.toString();
                                if (currentValue == null) {
                                    currentValue = placeholderMap.get(propertyName);
                                    if (currentValue instanceof ITemplate) {
                                        renderer.render(( (ITemplate) currentValue ).render());
                                    } else {
                                        renderer.render(currentValue);
                                    }
                                    currentValue = null;
                                } else {
                                    Field field = ReflectionUtilities.findFieldIn(currentValue.getClass(), propertyName);
                                    if (field == null) {
                                        sb.append("{").append(propertyName).append("}");
                                    } else {
                                        Object fieldValue = ReflectionUtilities.getFieldValueFrom(field, currentValue);
                                        currentPlaceholderKey = null;
                                        currentValue = null;
                                        if (fieldValue == null) {
                                            sb.append("NULL");
                                        } else {
                                            sb.append(fieldValue);
                                        }
                                    }
                                }

                                sb.setLength(0);
                            }
                            inPlaceholder = false;
                            inIndexer = false;
                        } else if (templateCharacter == '[') {
                            String propertyName = sb.toString();
                            if (inPlaceholder) {
                                if (currentValue == null) {
                                    currentValue = placeholderMap.get(propertyName);
                                } else {
                                    Field field = ReflectionUtilities.findFieldIn(currentValue.getClass(), propertyName);
                                    currentValue = ReflectionUtilities.getFieldValueFrom(field, currentValue);
                                    currentPlaceholderKey = propertyName;
                                }
                                sb.setLength(0);

                                inIndexer = true;
                            } else {
                                renderer.render((char) templateCharacter);
                                length++;
                            }                                
                        } else if (templateCharacter == ']') {
                            if (inPlaceholder) {
                                if (inIndexer) {
                                    String propertyName = sb.toString();
                                    try {
                                        int indexValue = Integer.parseInt(propertyName);

                                        if (currentValue.getClass().isArray()) {
                                            currentValue = Array.get(currentValue, indexValue);
                                        } else if (currentValue instanceof List<?>) {
                                            currentValue = ( (List<?>) currentValue ).get(indexValue);
                                        } else if (currentValue instanceof Map<?, ?>) {
                                            currentValue = ( (Map<?, ?>) currentValue ).get(indexValue);
                                        }
                                    }
                                    catch (NumberFormatException nfex) {
                                        if (currentValue instanceof Map<?, ?>) {
                                            currentValue = ( (Map<?, ?>) currentValue ).get(propertyName);
                                        }
                                    }

                                    sb.setLength(0);

                                    inIndexer = false;
                                }
                            } else {
                                renderer.render((char) templateCharacter);
                                length++;
                            }
                        } else if (templateCharacter == '.') {
                            if (inPlaceholder) {
                                if (sb.length() > 0) {
                                    String propertyName = sb.toString();
                                    if (currentValue == null) {
                                        currentValue = placeholderMap.containsKey(currentPlaceholderKey);
                                        currentPlaceholderKey = propertyName;
                                    } else {
                                        Field field = ReflectionUtilities.findFieldIn(currentValue.getClass(), propertyName);
                                        currentValue = ReflectionUtilities.getFieldValueFrom(field, currentValue);
                                        currentPlaceholderKey = propertyName;
                                    }
                                    sb.setLength(0);
                                }
                            } else {
                                renderer.render((char) templateCharacter);
                                length++;
                            }
                        } else {
                            if (inPlaceholder) {
                                if (isControlCharacter(templateCharacter)) {
                                    inPlaceholder = false;
                                    renderer.render(sb.toString());
                                    length += sb.length();
                                    sb.setLength(0);
                                    renderer.render((char) templateCharacter);
                                    length++;
                                } else {
                                    sb.append((char) templateCharacter);
                                }
                            } else {
                                renderer.render((char) templateCharacter);
                                length++;
                            }
                        }
                    }
                }
                catch (IOException ioex) {
                    LOGGER.warn("Error", ioex); //TODO Enter precise error message
                    throw new com.ramforth.utilities.exceptions.IOException(ioex);
                }

                try {
                    reader.close();
                }
                catch (IOException ioex) {
                    LOGGER.warn("Error", ioex); //TODO Enter precise error message
                    throw new com.ramforth.utilities.exceptions.IOException(ioex);
                }
            }
            catch (IOException ioex) {
                LOGGER.warn("Error", ioex); //TODO Enter precise error message
                throw new com.ramforth.utilities.exceptions.IOException(ioex);
            }
        }
        return length;
    }

    @Override
    public long renderTo(OutputStream outputStream) {
        ICharRenderer renderer = new OutputStreamRenderer(outputStream);
        return renderTo(renderer);
    }

    @Override
    public String render() {
        StringBuilder renderBuilder = new StringBuilder();

        ICharRenderer renderer = new StringBuilderRenderer(renderBuilder);
        renderTo(renderer);

        return renderBuilder.toString();
    }

    public File getTemplate() {
        return template;
    }

    @Override
    public long getLength() {
        long templateLength = template.length();
        for (Map.Entry<String, Object> entry : placeholderMap.entrySet()) {
            templateLength -= entry.getKey().getBytes().length;
            if (entry.getValue() == null) {
                templateLength += "null".getBytes().length;
            } else if (entry.getValue() instanceof String) {
                templateLength += ( (String) entry.getValue() ).getBytes().length;
            } else if (entry.getValue() instanceof ITemplate) {
                templateLength += ( (ITemplate) entry.getValue() ).getLength();
            }
        }
        return templateLength;
    }
}
