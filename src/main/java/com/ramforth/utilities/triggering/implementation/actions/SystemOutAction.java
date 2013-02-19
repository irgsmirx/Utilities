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