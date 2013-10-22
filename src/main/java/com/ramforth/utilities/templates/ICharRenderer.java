/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.templates;

import java.nio.charset.Charset;

/**
 *
 * @author tobias
 */
public interface ICharRenderer {

    Charset getCharset();
    
    void setCharset(Charset charset);
    
    void render(char c);

    void render(String s);

    void render(Object o);
    
}
