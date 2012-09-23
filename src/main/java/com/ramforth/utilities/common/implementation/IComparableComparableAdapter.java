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
public final class IComparableComparableAdapter implements Comparable {

    private IComparable adaptee;

    public IComparableComparableAdapter(IComparable adaptee) {
        this.adaptee = adaptee;
    }

    public final IComparable getAdaptee() {
        return adaptee;
    }

    public void setAdaptee(IComparable value) {
        this.adaptee = value;
    }

    @Override
    public int compareTo(Object o) {
        int result;

        if (adaptee.isEqualTo(o)) {
            result = 0;
        } else if (adaptee.isGreaterThan(o)) {
            result = 1;
        } else {
            result = -1;
        }

        return result;
    }
}
