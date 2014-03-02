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
 * @author ramforth
 */
public class StringTemplate extends AbstractTemplate {

    private final String template;

    public StringTemplate(String template) {
        super();
        this.template = template;
    }

    @Override
    protected Reader tryCreateReader() {
        return new BufferedReader(new StringReader(template));
    }

    @Override
    public String render() {
        StringBuilder renderBuilder = new StringBuilder();

        ICharRenderer renderer = new StringBuilderRenderer(renderBuilder);
        renderer.setCharset(this.charset);
        renderTo(renderer);

        return renderBuilder.toString();
    }

    @Override
    public long getLengthInBytes() {
        long templateLength = template.getBytes(charset).length;

        return correctTemplateLength(templateLength);
    }
    
    @Override
    public String getTemplate() {
        return template;
    }

    @Override
    protected void tryClose() {
        // nothing to do here
    }
}
