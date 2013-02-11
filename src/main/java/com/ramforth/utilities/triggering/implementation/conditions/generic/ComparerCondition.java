package com.ramforth.utilities.triggering.implementation.conditions.generic;

import com.ramforth.utilities.triggering.implementation.conditions.AbstractComparerCondition;
import java.util.Comparator;

//[Description("Bedingung, die erfüllt ist, wenn das Ergebnis der Compare(elementA, elementB)-Methode des übergebenen Comparers mit Wert der übergebenen comparisonValue übereinstimmt.")]
//[Category("Common")]
//[Serializable]
public class ComparerCondition<T> extends AbstractComparerCondition<T> {

    private Comparator<T> comparer = null;

    public Comparator<T> getComparer() {
        return comparer;
    }

    public void setComparer(Comparator<T> value) {
        this.comparer = value;
    }

    @Override
    public boolean isMet() {
        return ( comparer != null ) && ( comparer.compare(elementA, elementB) == comparisonResult );
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