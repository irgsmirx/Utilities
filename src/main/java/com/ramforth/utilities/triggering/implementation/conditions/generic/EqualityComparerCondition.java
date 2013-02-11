package com.ramforth.utilities.triggering.implementation.conditions.generic;

//[Description("Bedingung, die erfüllt ist, wenn die Equals(elementA, elementB)-Methode des übergebenen EqualityComparers 'true' zurückgibt.")]

import com.ramforth.utilities.common.interfaces.IEqualityComparatorGeneric;
import com.ramforth.utilities.triggering.implementation.conditions.AbstractCondition;

//[Category("Common")]
//[Serializable]
public class EqualityComparerCondition<T> extends AbstractCondition {

    private IEqualityComparatorGeneric<T> equalityComparer;
    private T elementA;
    private T elementB;

    public EqualityComparerCondition(IEqualityComparatorGeneric<T> equalityComparer, T elementA, T elementB) {
        this.equalityComparer = equalityComparer;
        this.elementA = elementA;
        this.elementB = elementB;
    }

    public IEqualityComparatorGeneric<T> getEqualityComparer() {
        return equalityComparer;
    }

    public void setEqualityComparer(IEqualityComparatorGeneric<T> value) {
        this.equalityComparer = value;
    }

    public T getElementA() {
        return elementA;
    }

    public void setElementA(T value) {
        elementA = value;
    }

    public T getElementB() {
        return elementB;
    }

    public void setElementB(T value) {
        elementB = value;
    }

    @Override
    public boolean isMet() {
        return equalityComparer.equals(elementA, elementB);
    }

    @Override
    public String toString() {
        return String.format("{%1s} == {%2s}", elementA.toString(), elementB.toString());
    }

    @Override
    public String getFormatString() {
        return "{elementA} == {elementB}";
    }
}