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

//[Description("Aktion, die die angegebene outMessage nach Console.Out schreibt.")]
import com.ramforth.utilities.common.implementation.StringUtilities;
import java.io.PrintStream;

//[Category("Console")]
//[Serializable]
public final class SystemOutAction extends PrintStreamAction {

    public SystemOutAction() {
        super();
        this.printStream = System.out;
    }

    @Override
    public PrintStream getPrintStream() {
        return printStream;
    }

    public String getOutMessage() {
        return text;
    }

    public void setOutMessage(String value) {
        this.text = value;
    }

    @Override
    public String toString() {
        return String.format("Schreibe \"%s\" nach System.out.", ( getOutMessage() == null ? StringUtilities.EMPTY : getOutMessage() ));
    }
}