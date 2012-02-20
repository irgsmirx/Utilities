/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.implementation;

import common.interfaces.IComparable;
import common.interfaces.IComparableGeneric;

/**
 *
 * @author Administrator
 */
public final class ComparableIComparableGenericAdapter<T> implements IComparableGeneric<T> {

    private Comparable<T> adaptee;
    
    public ComparableIComparableGenericAdapter(Comparable<T> adaptee) {
        this.adaptee = adaptee;
    }
    
    public final Comparable<T> getAdaptee() {
        return adaptee;
    }
    
    public void setAdaptee(Comparable<T> value) {
        this.adaptee = value;
    }

    @Override
    public boolean isGreaterThan(T o) {
        return adaptee.compareTo(o) > 0;
    }

    @Override
    public boolean isLessThan(T o) {
        return adaptee.compareTo(o) < 0;
    }

    @Override
    public boolean isEqualTo(T x) {
        return adaptee.compareTo(x) == 0;
    }
    
}
