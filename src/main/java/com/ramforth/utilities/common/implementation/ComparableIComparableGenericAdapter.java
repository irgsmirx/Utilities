/* 
 * Copyright (C) 2014 Tobias Ramforth
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ramforth.utilities.common.implementation;

import com.ramforth.utilities.common.interfaces.IComparable;
import com.ramforth.utilities.common.interfaces.IComparableGeneric;

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
