package com.ramforth.utilities.triggering.implementation.actions;

import com.ramforth.utilities.common.implementation.StringUtilities;
import java.io.PrintStream;

//[Description("Aktion, die die angegebene outMessage nach Console.Error schreibt.")]
//[Category("Console")]
//[Serializable]
public final class SystemErrorAction extends TextWriterAction {

    public SystemErrorAction() {
        super();
        this.textWriter = System.err;
    }

    @Override
    public PrintStream getTextWriter() {
        return textWriter;
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