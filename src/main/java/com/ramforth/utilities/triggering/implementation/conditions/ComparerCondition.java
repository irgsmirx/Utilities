package com.ramforth.utilities.triggering.implementation.conditions;

import java.util.Comparator;

//  [Description("Bedingung, die erfüllt ist, wenn das Ergebnis der Compare(elementA, elementB)-Methode des übergebenen Comparers mit Wert der übergebenen comparisonResult übereinstimmt.")]
//  [Category("Common")]
//  [Serializable]
public class ComparerCondition extends AbstractComparerCondition<Object> {

    private Comparator comparer = null;

    public Comparator getComparer() {
        return comparer;
    }

    public void setComparer(Comparator value) {
        this.comparer = value;
    }

    @Override
    public boolean isMet() {
        return ( comparer != null ) && comparer.compare(elementA, elementB) == comparisonResult;
    }

    @Override
    public String toString() {
        return String.format("{%1s} {%2s} {%3s}", elementA.toString(), comparer.toString(), elementB.toString());
    }

    @Override
    public String getFormatString() {
        return "{elementA} {comparer} {elementB}";
    }
}
