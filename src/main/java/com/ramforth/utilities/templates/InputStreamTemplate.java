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

import java.io.*;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class InputStreamTemplate extends AbstractTemplate {

    protected InputStream template;

    public InputStreamTemplate(InputStream inputStream) {
        super();
        this.template = inputStream;
    }

    @Override
    protected Reader tryCreateReader() {
        return new BufferedReader(new InputStreamReader(template, charset));
    }
    
    @Override
    protected void tryClose() {
        try {
            this.template.close();
        } catch (IOException ioex) {
            LOGGER.warn("Error closing template!", ioex);
            throw new com.ramforth.utilities.exceptions.IOException(ioex);
        }
    }

    @Override
    public String render() {
        StringBuilder renderBuilder = new StringBuilder();

        ICharRenderer renderer = new StringBuilderRenderer(renderBuilder);
        renderTo(renderer);

        return renderBuilder.toString();
    }

    @Override
    public long getLengthInBytes() {
        long templateLength = 0;
        try {
            templateLength = template.available();
        }
        catch (IOException ex) {
            return -1;
        }
        
        return correctTemplateLength(templateLength);
    }
    
    @Override
    public Object getTemplate() {
        return template;
    }
    
}

