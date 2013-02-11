package com.ramforth.utilities.triggering.implementation.conditions;

//[Description("Bedingung, die erfüllt ist, wenn die Equals(elementA, elementB)-Methode des übergebenen EqualityComparers 'true' zurückgibt.")]
import com.ramforth.utilities.common.interfaces.IEqualityComparator;

//[Category("Common")]
//[Serializable]
public class EqualityComparerCondition extends AbstractCondition {

    private IEqualityComparator equalityComparer = null;
    private Object elementA = null;
    private Object elementB = null;

    public IEqualityComparator getEqualityComparer() {
        return equalityComparer;
    }

    public void setEqualityComparer(IEqualityComparator value) {
        this.equalityComparer = value;
    }

    public Object getElementA() {
        return elementA;
    }

    public void setElementA(Object value) {
        elementA = value;
    }

    public Object getElementB() {
        return elementB;
    }

    public void setElementB(Object value) {
        elementB = value;
    }

    @Override
    public boolean isMet() {
        return ( equalityComparer != null ) && equalityComparer.equals(elementA, elementB);
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