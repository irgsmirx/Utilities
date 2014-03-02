/* 
 * Copyright (C) 2014 Tobias Ramforth
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
