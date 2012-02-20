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
public final class IComparableComparableGenericAdapter<T> implements Comparable<T> {

    private IComparableGeneric<T> adaptee;
    
    public IComparableComparableGenericAdapter(IComparableGeneric<T> adaptee) {
        this.adaptee = adaptee;
    }
    
    public final IComparableGeneric<T> getAdaptee() {
        return adaptee;
    }
    
    public void setAdaptee(IComparableGeneric<T> value) {
        this.adaptee = value;
    }
    
    @Override
    public int compareTo(T o) {
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
