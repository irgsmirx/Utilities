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
            || characterCode == '\r' || characterCode == '\r';
  }
	
}
