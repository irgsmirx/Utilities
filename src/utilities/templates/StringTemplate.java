/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package templates;

import java.io.OutputStream;
import java.io.StringReader;

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

        PropertyInfo currentPropertyInfo = null;
        String currentPlaceholderKey = null;
        Object currentValue = null;

        StringReader stringReader = new StringReader(template);
        int templateCharacter = -1;
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
                currentPropertyInfo = currentValue.GetType().GetProperty(propertyName);
                Object propertyValue = currentPropertyInfo.GetGetMethod().Invoke(currentValue, null);
                if (propertyValue == null) {
                  propertyLabel.Text = "{" + propertyName + "}";
                } else {
                  String stringValue = propertyValue.toString().trim();
                  if (stringValue.Length == 0) {
                    propertyLabel.Text = "__";
                  } else {
                    propertyLabel.Text = stringValue;
                  }
                }
                sb.setLength(0);
              }
              inPlaceholder = false;
              inIndexer = false;
          } else if (templateCharacter == '[') {
              if (inPlaceholder) {
                currentPropertyInfo = currentValue.GetType().GetProperty(sb.toString());
                currentValue = currentPropertyInfo.GetValue(currentValue, null);
                sb.setLength(0);

                inIndexer = true;
              } else {
                sb.append(templateCharacter);
              }
          } else if (templateCharacter == ']') {
              if (inPlaceholder) {
                if (inIndexer) {
                  ParameterInfo[] indexParameters = currentPropertyInfo.GetIndexParameters();

                  try {
                    Int64 intIndexValue = Int64.Parse(sb.toString());
                    foreach (ParameterInfo indexParameter in indexParameters) {
                      if (indexParameter.ParameterType == typeof(Int64) 
                        || indexParameter.ParameterType == typeof(Int32)
                        || indexParameter.ParameterType == typeof(Int16)) {
                        currentValue = currentPropertyInfo.GetValue(currentValue, new Object[] { intIndexValue } );
                        break;
                      }
                    }
                  } catch (Exception ex) {
                    currentValue = currentPropertyInfo.GetValue(currentValue, new Object[] { sb.toString() });
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
                  if (currentPlaceholderKey == null) {
                      currentPlaceholderKey = sb.toString();
                      currentValue = placeholderMap.containsKey(currentPlaceholderKey);
                  } else {
                    currentPropertyInfo = currentValue.GetType().GetProperty(sb.toString());
                    currentValue = currentPropertyInfo.GetValue(currentValue, null);
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
      }
      
      return renderBuilder.toString();
    }
    
}
