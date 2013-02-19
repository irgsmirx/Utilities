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