package com.ramforth.utilities.triggering.implementation.actions;

//[Description("Aktion, die nichts ausführt.")]
//[Category("Common")]
//[Serializable]
public final class NullAction extends AbstractAction {

    public NullAction() {
        super();
    }

    @Override
    public void perform() {
    }

    @Override
    public String toString() {
        return "Nichts";
    }

    @Override
    public String getFormatString() {
        return "Nichts";
    }
}