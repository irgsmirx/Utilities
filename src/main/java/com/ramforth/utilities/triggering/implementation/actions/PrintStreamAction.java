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
package com.ramforth.utilities.triggering.implementation.actions;

import com.ramforth.utilities.common.implementation.StringUtilities;
import java.io.PrintStream;

//[Description("Aktion, die den angegebenen Text als Zeile in einen TextWriter schreibt.")]
//[Category("I/O")]
//[Serializable]
public class PrintStreamAction extends AbstractAction {

    protected PrintStream printStream = null;
    protected String text = StringUtilities.EMPTY;

    public PrintStream getPrintStream() {
        return printStream;
    }

    public void setPrintStream(PrintStream value) {
        this.printStream = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String value) {
        this.text = value;
    }

    @Override
    public void perform() {
        printStream.print(text);
    }

    @Override
    public String toString() {
        return String.format("Schreibe den Text \"%s\" als Zeile in den PrintStream \"%s\".", ( text == null ? StringUtilities.EMPTY : text ), printStream);
    }

    @Override
    public String getFormatString() {
        return "Schreibe den Text {text} als Zeile in den PrintStream {textWriter}.";
    }
}