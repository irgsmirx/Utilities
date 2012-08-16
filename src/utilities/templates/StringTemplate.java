/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.templates;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void renderTo(OutputStream outputStream) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String render() {
      StringBuilder renderBuilder = new StringBuilder();
      
      if (template != null && !placeholderMap.isEmpty()) {
        StringBuilder sb = new StringBuilder();
        
        boolean inPlaceholder = false;
        boolean inIndexer = false;

        Field currentField = null;
        String currentPlaceholderKey = null;
        Object currentValue = null;

        StringReader stringReader = new StringReader(template);
        int templateCharacter = -1;
        try {
          while ((templateCharacter = stringReader.read()) != -1) {
            if (templateCharacter == placeholderBeginTag) {
                if (inPlaceholder) {
                  sb.append(templateCharacter);
                } else {
                  inPlaceholder = true;
                }
            } else if (templateCharacter == placeholderEndTag) {
                if (sb.length() > 0) {
                  String propertyName = sb.toString();
                  if (currentValue == null) {
                    currentValue = placeholderMap.get(propertyName);
                    renderBuilder.append(currentValue);
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
                }
                inPlaceholder = false;
                inIndexer = false;
            } else if (templateCharacter == '[') {
              String propertyName = sb.toString();  
              if (inPlaceholder) {
                currentField = ReflectionUtilities.findFieldIn(currentValue.getClass(), propertyName);
                currentValue = ReflectionUtilities.getFieldValueFrom(currentField, currentValue);
                sb.setLength(0);

                inIndexer = true;
              } else {
                sb.append(templateCharacter);
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
                        currentValue = ((List<?>)currentValue).get(indexValue);
                      } else if (currentValue instanceof Map<?, ?>) {
                        currentValue = ((Map<?, ?>)currentValue).get(indexValue);
                      }
                    } catch (NumberFormatException nfex) {
                      if (currentValue instanceof Map<?, ?>) {
                        currentValue = ((Map<?, ?>)currentValue).get(propertyName);
                      }
                    }
                    
                    sb.setLength(0);

                    inIndexer = false;
                  }
                } else {
                  sb.append(templateCharacter);
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
                  sb.append(templateCharacter);
                }
            } else {
                sb.append(templateCharacter);
            }
          }
        } catch (IOException ioex) {
          Logger.getLogger(StringTemplate.class.getName()).log(Level.SEVERE, null, ioex);
          throw new utilities.exceptions.IOException(ioex);
        }
      }
      
      return renderBuilder.toString();
    }
    
}
