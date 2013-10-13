/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.templates;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author ramforth
 */
public abstract class AbstractTemplate implements ITemplate {
   
    protected char placeholderBeginTag = '{';
    protected char placeholderEndTag = '}';
    protected String escapeCharacter = "\\";
    protected Map<String, Object> placeholderMap = new TreeMap<>();
    protected Map<Class<?>, ICustomRenderer> customRenderers = new TreeMap<>();

    public AbstractTemplate() {
    }

    public AbstractTemplate(char placeholderBeginTag, char placeholderEndTag, String escapeCharacter) {
        this.placeholderBeginTag = placeholderBeginTag;
        this.placeholderEndTag = placeholderEndTag;
        this.escapeCharacter = escapeCharacter;
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
        return new String(new char[] { placeholderBeginTag, placeholderEndTag }).getBytes().length;
    }
        
    protected long correctTemplateLength(long templateLength) {
        long beginAndEndTagBytesLength = getBeginAndEndTagBytesLength();
        
        for (Map.Entry<String, Object> entry : placeholderMap.entrySet()) {
            templateLength -= entry.getKey().getBytes().length;
            templateLength -= beginAndEndTagBytesLength;
            
            Object value = entry.getValue();
            if (value == null) {
                templateLength += "null".getBytes().length;
            } else if (value instanceof String) {
                templateLength += ( (String) value ).getBytes().length;
            } else if (value instanceof ITemplate) {
                templateLength += ( (ITemplate) value ).getLength();
            }
        }

        return templateLength;
    }
    
}
