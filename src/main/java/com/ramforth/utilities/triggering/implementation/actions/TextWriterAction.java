package com.ramforth.utilities.triggering.implementation.actions;

import com.ramforth.utilities.common.implementation.StringUtilities;
import java.io.PrintStream;

//[Description("Aktion, die den angegebenen Text als Zeile in einen TextWriter schreibt.")]
//[Category("I/O")]
//[Serializable]
public class TextWriterAction extends AbstractAction {

    protected PrintStream textWriter = null;
    protected String text = StringUtilities.EMPTY;

    public PrintStream getTextWriter() {
        return textWriter;
    }

    public void setTextWriter(PrintStream value) {
        this.textWriter = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String value) {
        this.text = value;
    }

    @Override
    public void perform() {
        textWriter.println(text);
    }

    @Override
    public String toString() {
        return String.format("Schreibe den Text \"{0}\" als Zeile in den TextWriter \"{1}\".", ( text == null ? StringUtilities.EMPTY : text ), textWriter);
    }

    @Override
    public String getFormatString() {
        return "Schreibe den Text {Text} als Zeile in den TextWriter {TextWriter}.";
    }
}