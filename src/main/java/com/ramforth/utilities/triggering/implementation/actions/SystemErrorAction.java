package com.ramforth.utilities.triggering.implementation.actions;

import com.ramforth.utilities.common.implementation.StringUtilities;
import java.io.PrintStream;

//[Description("Aktion, die die angegebene outMessage nach Console.Error schreibt.")]
//[Category("Console")]
//[Serializable]
public final class SystemErrorAction extends PrintStreamAction {

    public SystemErrorAction() {
        super();
        this.printStream = System.err;
    }

    @Override
    public PrintStream getPrintStream() {
        return printStream;
    }

    public String getErrorMessage() {
        return text;
    }

    public void setErrorMessage(String value) {
        this.text = value;
    }

    @Override
    public String toString() {
        return String.format("Schreibe \"{0}\" nach Console.Error.", ( getErrorMessage() == null ? StringUtilities.EMPTY : getErrorMessage() ));
    }
}