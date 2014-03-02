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
