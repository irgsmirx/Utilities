/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.templates;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
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

	private void renderTo(ICharRenderer renderer) {
		if (template != null) {
			StringBuilder sb = new StringBuilder();

			boolean inPlaceholder = false;
			boolean inIndexer = false;

			Field currentField = null;
			String currentPlaceholderKey = null;
			Object currentValue = null;

			Reader stringReader = new StringReader(template);
			int templateCharacter;
			try {
				while ((templateCharacter = stringReader.read()) != -1) {
					if (templateCharacter == placeholderBeginTag) {
						if (inPlaceholder) {
							sb.append((char)templateCharacter);
						} else {
							inPlaceholder = true;
						}
					} else if (templateCharacter == placeholderEndTag) {
						if (sb.length() > 0) {
							String propertyName = sb.toString();
							if (currentValue == null) {
								currentValue = placeholderMap.get(propertyName);
								renderer.render(currentValue);
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
							renderer.render((char)templateCharacter);
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
							renderer.render((char)templateCharacter);
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
							renderer.render((char)templateCharacter);
						}
					} else {
						if (inPlaceholder) {
							sb.append((char)templateCharacter);
						} else {
							renderer.render((char)templateCharacter);
						}
					}
				}
			} catch (IOException ioex) {
				Logger.getLogger(StringTemplate.class.getName()).log(Level.SEVERE, null, ioex);
				throw new utilities.exceptions.IOException(ioex);
			}
      
      try {
        stringReader.close();
      } catch (IOException ioex) {
        Logger.getLogger(InputStreamTemplate.class.getName()).log(Level.SEVERE, null, ioex);
				throw new utilities.exceptions.IOException(ioex);
      }
		}
		
	}
	
	@Override
	public void renderTo(OutputStream outputStream) {
		ICharRenderer renderer = new OutputStreamRenderer(outputStream);
		renderTo(renderer);
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
		return template.length();
	}
	
  public String getTemplate() {
    return template;
  }
  
	
	
}
