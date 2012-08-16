/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.templates;

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

    protected Map<String, Object> placeholderMap = new TreeMap<String, Object>();
    
    public AbstractTemplate() {
    }
    
    public AbstractTemplate(char placeholderBeginTag, char placeholderEndTag, String escapeCharacter) {
        this.placeholderBeginTag = placeholderBeginTag;
        this.placeholderEndTag = placeholderEndTag;
        this.escapeCharacter = escapeCharacter;
    }
    
    public void add(String placeholder, Object value) {
        placeholderMap.put(placeholder, value);
    }

    public void remove(String placeholder) {
        placeholderMap.remove(placeholder);
    }

    public void clear() {
        placeholderMap.clear();
    }

    public int numberOfPlaceholders() {
        return placeholderMap.size();
    }
    
}
