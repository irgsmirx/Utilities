package com.ramforth.utilities.triggering.implementation.actions;

//[Description("Aktion, die die angegebene outMessage nach Console.Out schreibt.")]
import com.ramforth.utilities.common.implementation.StringUtilities;
import java.io.PrintStream;

//[Category("Console")]
//[Serializable]
public final class SystemOutAction extends TextWriterAction {

    public SystemOutAction() {
        super();
        this.textWriter = System.out;
    }

    @Override
    public PrintStream getTextWriter() {
        return textWriter;
    }

    public String getOutMessage() {
        return text;
    }

    public void setOutMessage(String value) {
        this.text = value;
    }

    @Override
    public String toString() {
        return String.format("Schreibe \"{0}\" nach Console.Error.", ( getOutMessage() == null ? StringUtilities.EMPTY : getOutMessage() ));
    }
}