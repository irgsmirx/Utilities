package com.ramforth.utilities.triggering.implementation.conditions;

//  [Description("Bedingung, die erfüllt ist, wenn das Ergebnis der Compare(elementA, elementB)-Methode des übergebenen Comparers mit Wert der übergebenen comparisonResult übereinstimmt.")]
//  [Category("Common")]
//  [Serializable]
public abstract class AbstractComparerCondition<T> extends AbstractCondition {

    protected T elementA;
    protected T elementB;
    protected int comparisonResult;

    //[DataMember]
    public T getElementA() {
        return elementA;
    }

    public void setElementA(T value) {
        elementA = value;
    }

    //[DataMember]
    public T getElementB() {
        return elementB;
    }

    public void setElementB(T value) {
        elementB = value;
    }

    //[DataMember]
    public int getComparisonResult() {
        return comparisonResult;
    }

    public void setComparisonResult(int value) {
        this.comparisonResult = value;
    }
}