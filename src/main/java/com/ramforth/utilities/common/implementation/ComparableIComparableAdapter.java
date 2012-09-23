/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.common.implementation;

import com.ramforth.utilities.common.interfaces.IComparable;

/**
 *
 * @author Administrator
 */
public final class ComparableIComparableAdapter implements IComparable {

    private Comparable adaptee;
    
    public ComparableIComparableAdapter(Comparable adaptee) {
        this.adaptee = adaptee;
    }
    
    public final Comparable getAdaptee() {
        return adaptee;
    }
    
    public void setAdaptee(Comparable value) {
        this.adaptee = value;
    }

    @Override
    public boolean isGreaterThan(Object o) {
        return adaptee.compareTo(o) > 0;
    }

    @Override
    public boolean isLessThan(Object o) {
        return adaptee.compareTo(o) < 0;
    }

    @Override
    public boolean isEqualTo(Object x) {
        return adaptee.compareTo(x) == 0;
    }
    

    
}
