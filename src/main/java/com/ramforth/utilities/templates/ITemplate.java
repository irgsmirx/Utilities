/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.templates;

import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 *
 * @author ramforth
 */
public interface ITemplate {

    void setCustomRenderer(Class<?> type, ICustomRenderer value);

    void unsetCustomRenderer(Class<?> type);

    void add(String placeholder, Object value);

    void remove(String placeholder);

    void clear();

    int numberOfPlaceholders();
    
    long renderTo(OutputStream outputStream);

    String render();

    long getLength();
    
    long getLength(Charset charset);
    
}
