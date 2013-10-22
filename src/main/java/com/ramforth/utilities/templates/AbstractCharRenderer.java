/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.templates;

import java.nio.charset.Charset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public abstract class AbstractCharRenderer implements ICharRenderer {
    
    protected static final Logger LOGGER = LoggerFactory.getLogger(AbstractCharRenderer.class);

    protected Charset charset = Charset.defaultCharset();
    
    @Override
    public void setCharset(Charset charset) {
        if (charset == null) {
            LOGGER.warn("Charset set to null. That could cause trouble.");
        }
        this.charset = charset;
    }

    @Override
    public Charset getCharset() {
        return charset;
    }
    
}
