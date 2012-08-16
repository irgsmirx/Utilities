/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.templates;

import java.io.OutputStream;

/**
 *
 * @author ramforth
 */
public interface ITemplate {
  
    void add(String placeholder, Object value);
    void remove(String placeholder);
    void clear();
    int numberOfPlaceholders();
    
    void renderTo(OutputStream outputStream);
    String render();
    
}
