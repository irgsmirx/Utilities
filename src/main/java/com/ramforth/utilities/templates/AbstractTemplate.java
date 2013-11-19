/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.templates;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ramforth
 */
public abstract class AbstractTemplate implements ITemplate {
   
    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractTemplate.class);

    protected static final String DEFAULT_PLACEHOLDER_BEGIN_TAG = "{";
    protected static final String DEFAULT_PLACEHOLDER_END_TAG = "}";
    protected static final String DEFAULT_ESCAPE_CHARARCTER = "\\";
    protected static final int INDEXER_BEGIN_CHARACTER = '[';
    protected static final int INDEXER_END_CHARACTER = ']';
    protected static final int FIELD_SEPARATOR_CHARACTER = '.';
    
    protected String placeholderBeginTag;
    protected String placeholderEndTag;
    protected String escapeCharacter;
    protected Map<String, Object> placeholderMap = new TreeMap<>();
    protected Map<Class<?>, ICustomRenderer> customRenderers = new TreeMap<>();

    protected Charset charset;
    
    public AbstractTemplate() {
        placeholderBeginTag = DEFAULT_PLACEHOLDER_BEGIN_TAG;
        placeholderEndTag = DEFAULT_PLACEHOLDER_END_TAG;
        escapeCharacter = DEFAULT_ESCAPE_CHARARCTER;
        charset = Charset.defaultCharset();
    }

    public AbstractTemplate(String placeholderBeginTag, String placeholderEndTag, String escapeCharacter) {
        this.placeholderBeginTag = placeholderBeginTag;
        this.placeholderEndTag = placeholderEndTag;
        this.escapeCharacter = escapeCharacter;
        charset = Charset.defaultCharset();
    }

    @Override
    public void add(String placeholder, Object value) {
        placeholderMap.put(placeholder, value);
    }

    @Override
    public void remove(String placeholder) {
        placeholderMap.remove(placeholder);
    }

    @Override
    public void clear() {
        placeholderMap.clear();
    }

    @Override
    public int numberOfPlaceholders() {
        return placeholderMap.size();
    }

    @Override
    public Iterable<String> usedPlaceholders() {
        List<String> usedPlaceholders = new ArrayList<>();

        if (getTemplate() != null) {
            StringBuilder sb = new StringBuilder();
            StringBuilder temp = new StringBuilder();
            
            boolean inPlaceholder = false;
            boolean inIndexer = false;

            String currentPlaceholderKey = null;
            Object currentValue = null;

            int lastMatchedBeginTagPosition = 0;
            int lastMatchedEndTagPosition = 0;
            
            try (Reader reader = tryCreateReader()) {
                int templateCharacter = -1;
                try {
                    while (( templateCharacter = reader.read() ) != -1) {
                        if (templateCharacter == placeholderBeginTag.codePointAt(lastMatchedBeginTagPosition)) {
                            lastMatchedBeginTagPosition++;
                            if (lastMatchedBeginTagPosition == placeholderBeginTag.length()) {
                                lastMatchedBeginTagPosition = 0;
                                if (inPlaceholder) {
                                    sb.append((char) templateCharacter);
                                } else {
                                    inPlaceholder = true;
                                }
                            }
                        } else {
                            lastMatchedBeginTagPosition = 0;
                            
                            if (templateCharacter == placeholderEndTag.codePointAt(lastMatchedEndTagPosition)) {
                                lastMatchedEndTagPosition++;
                                if (lastMatchedEndTagPosition == placeholderEndTag.length()) {
                                    lastMatchedEndTagPosition = 0;
                                    if (sb.length() > 0) {
                                        String propertyName = sb.toString();
                                        if (currentValue == null) {
                                            currentValue = placeholderMap.get(propertyName);
                                            if (placeholderMap.containsKey(propertyName)) {
                                                usedPlaceholders.add(propertyName);
                                            }
                                            currentValue = null;
                                        } else {
                                            Field field = ReflectionUtilities.findFieldIn(currentValue.getClass(), propertyName);
                                            Object fieldValue = ReflectionUtilities.getFieldValueFrom(field, currentValue);
                                            currentPlaceholderKey = null;
                                            currentValue = null;
                                            if (fieldValue == null) {
                                                sb.append("NULL");
                                            } else {
                                                sb.append(fieldValue);
                                            }
                                        }

                                        sb.setLength(0);
                                    } else {
                                        if (currentValue != null) {
                                            sb.append(currentValue);
                                            sb.setLength(0);
                                        }
                                    }
                                    inPlaceholder = false;
                                    inIndexer = false;
                                }
                            } else {
                                lastMatchedEndTagPosition = 0;
                                
                                if (templateCharacter == INDEXER_BEGIN_CHARACTER) {
                                    String propertyName = sb.toString();
                                    if (inPlaceholder) {
                                        if (currentValue == null) {
                                            if (placeholderMap.containsKey(propertyName)) {
                                                usedPlaceholders.add(propertyName);
                                            }
                                            currentValue = placeholderMap.get(propertyName);
                                        } else {
                                            Field field = ReflectionUtilities.findFieldIn(currentValue.getClass(), propertyName);
                                            currentValue = ReflectionUtilities.getFieldValueFrom(field, currentValue);
                                            currentPlaceholderKey = propertyName;
                                        }
                                        sb.setLength(0);

                                        inIndexer = true;
                                    } else {
                                    }
                                } else if (templateCharacter == INDEXER_END_CHARACTER) {
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
                                    }
                                } else if (templateCharacter == FIELD_SEPARATOR_CHARACTER) {
                                    if (inPlaceholder) {
                                        if (sb.length() > 0) {
                                            String propertyName = sb.toString();
                                            if (currentValue == null) {
                                                currentValue = placeholderMap.get(propertyName);
                                                if (placeholderMap.containsKey(propertyName)) {
                                                    usedPlaceholders.add(propertyName);
                                                }
                                                currentPlaceholderKey = propertyName;
                                            } else {
                                                Field field = ReflectionUtilities.findFieldIn(currentValue.getClass(), propertyName);
                                                currentValue = ReflectionUtilities.getFieldValueFrom(field, currentValue);
                                                currentPlaceholderKey = propertyName;
                                            }
                                            sb.setLength(0);
                                        }
                                    } else {
                                    }
                                } else {
                                    if (inPlaceholder) {
                                        if (isControlCharacter(templateCharacter)) {
                                            inPlaceholder = false;
                                            sb.setLength(0);
                                        } else {
                                            sb.append((char) templateCharacter);
                                        }
                                    } else {
                                    }
                                }
                            }
                        }
                    }
                }
                catch (IOException ioex) {
                    LOGGER.warn("Error reading template." + (templateCharacter == -1 ? "" : " Last character read: " + (char)templateCharacter + "."), ioex);
                    throw new com.ramforth.utilities.exceptions.IOException(ioex);
                }

                try {
                    reader.close();
                }
                catch (IOException ioex) {
                    LOGGER.warn("Error closing template reader", ioex);
                    throw new com.ramforth.utilities.exceptions.IOException(ioex);
                }

                tryClose();
            }
            catch (IOException ioex) {
                LOGGER.warn("Error creating reader for template.", ioex);
                throw new com.ramforth.utilities.exceptions.IOException(ioex);
            }
        }

        return usedPlaceholders;
    }

    @Override
    public void setCustomRenderer(Class<?> type, ICustomRenderer value) {
        customRenderers.put(type, value);
    }

    @Override
    public void unsetCustomRenderer(Class<?> type) {
        customRenderers.remove(type);
    }

    public boolean isControlCharacter(int characterCode) {
        return characterCode == '\b' || characterCode == '\t'
                || characterCode == '\n' || characterCode == '\f'
                || characterCode == '\r';
    }
    
    private long getBeginAndEndTagBytesLength() {
        return getBeginAndEndTagBytesLength(this.charset);
    }
    
    private long getBeginAndEndTagBytesLength(Charset charset) {
        return placeholderBeginTag.getBytes(charset).length + placeholderEndTag.getBytes(charset).length;
    }
    
    protected long correctTemplateLength(long templateLength) {
        long beginAndEndTagBytesLength = getBeginAndEndTagBytesLength();
        
        for (String key : usedPlaceholders()) {
            templateLength -= key.getBytes(charset).length;
            templateLength -= beginAndEndTagBytesLength;
            
            Object value = placeholderMap.get(key);
            if (value == null) {
                templateLength += "null".getBytes(charset).length;
            } else if (value instanceof String) {
                templateLength += ( (String) value ).getBytes(charset).length;
            } else if (value instanceof ITemplate) {
                templateLength += ( (ITemplate) value ).getLengthInBytes();
            }
        }

        return templateLength;
    }
    
    protected long renderTo(ICharRenderer renderer) {
        long length = 0;
        if (getTemplate() != null) {
            StringBuilder sb = new StringBuilder();

            boolean inPlaceholder = false;
            boolean inIndexer = false;

            String currentPlaceholderKey = null;
            Object currentValue = null;

            try (Reader reader = tryCreateReader()) {
                int templateCharacter;
                try {
                    while (( templateCharacter = reader.read() ) != -1) {
                        if (templateCharacter == placeholderBeginTag) {
                            if (inPlaceholder) {
                                sb.append((char) templateCharacter);
                                length++;
                            } else {
                                inPlaceholder = true;
                            }
                        } else if (templateCharacter == placeholderEndTag) {
                            if (sb.length() > 0) {
                                String propertyName = sb.toString();
                                if (currentValue == null) {
                                    currentValue = placeholderMap.get(propertyName);
                                    currentPlaceholderKey = propertyName;
                                    if (currentValue instanceof ITemplate) {
                                        String subTemplate = ((ITemplate) currentValue).render();
                                        renderer.render(subTemplate);
                                        length += subTemplate.length();
                                    } else {
                                        renderer.render(currentValue);
                                        try {
                                            length += currentValue.toString().getBytes(charset).length;
                                        } catch (Exception ex) {
                                            LOGGER.warn("Could not determine byte length of currentValue.", ex);
                                        }
                                    }
                                    currentValue = null;
                                } else {
                                    Field field = ReflectionUtilities.findFieldIn(currentValue.getClass(), propertyName);
                                    Object fieldValue = ReflectionUtilities.getFieldValueFrom(field, currentValue);
                                    currentPlaceholderKey = null;
                                    currentValue = null;
                                    if (fieldValue == null) {
                                        sb.append("NULL");
                                    } else {
                                        sb.append(fieldValue);
                                    }
                                }

                                sb.setLength(0);
                            } else {
                                if (currentValue != null) {
                                    sb.append(currentValue);
                                    renderer.render(currentValue);
                                    length += sb.length();
                                    sb.setLength(0);
                                }
                            }
                            inPlaceholder = false;
                            inIndexer = false;
                        } else if (templateCharacter == INDEXER_BEGIN_CHARACTER) {
                            String propertyName = sb.toString();
                            if (inPlaceholder) {
                                if (currentValue == null) {
                                    currentValue = placeholderMap.get(propertyName);
                                    currentPlaceholderKey = propertyName;
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
                        } else if (templateCharacter == INDEXER_END_CHARACTER) {
                            if (inPlaceholder) {
                                if (inIndexer) {
                                    String propertyName = sb.toString();
                                    try {
                                        int indexValue = Integer.parseInt(propertyName);

                                        if (currentValue.getClass().isArray()) {
                                            currentValue = Array.get(currentValue, indexValue);
                                        } else if (currentValue instanceof List<?>) {
                                            currentValue = ((List<?>) currentValue).get(indexValue);
                                        } else if (currentValue instanceof Map<?, ?>) {
                                            currentValue = ((Map<?, ?>) currentValue).get(indexValue);
                                        }
                                    } catch (NumberFormatException nfex) {
                                        if (currentValue instanceof Map<?, ?>) {
                                            currentValue = ((Map<?, ?>) currentValue).get(propertyName);
                                        }
                                    }

                                    sb.setLength(0);

                                    inIndexer = false;
                                }
                            } else {
                                renderer.render((char) templateCharacter);
                                length++;
                            }
                        } else if (templateCharacter == FIELD_SEPARATOR_CHARACTER) {
                            if (inPlaceholder) {
                                if (sb.length() > 0) {
                                    String propertyName = sb.toString();
                                    if (currentValue == null) {
                                        currentValue = placeholderMap.get(propertyName);
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
                                    length++;
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
                
                tryClose();
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
        renderer.setCharset(charset);
        return renderTo(renderer);
    }

    @Override
    public void setCharset(Charset charset) {
        if (charset == null) {
            LOGGER.warn("Charset set to null. This is going to cause trouble.");
        }
        this.charset = charset;
    }

    @Override
    public final Charset getCharset() {
        return charset;
    }
    
    public abstract Object getTemplate();
    
    protected abstract Reader tryCreateReader();
    
    protected abstract void tryClose();
    
}
