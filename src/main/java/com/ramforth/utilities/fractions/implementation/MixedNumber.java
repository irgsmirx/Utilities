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
package com.ramforth.utilities.fractions.implementation;

import com.ramforth.utilities.fractions.interfaces.IFraction;
import com.ramforth.utilities.fractions.interfaces.IMixedNumer;
import com.ramforth.utilities.fractions.interfaces.ISimpleFraction;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public final class MixedNumber extends AbstractFraction implements IMixedNumer {

    protected int integerPart;
    protected ISimpleFraction fractionPart;

    public MixedNumber(int integerPart, int numerator, int denominator) {
        this(integerPart, new SimpleFraction(numerator, denominator));
    }

    public MixedNumber(int integerPart, ISimpleFraction fractionPart) {
        setIntegerPart(integerPart);
        setFractionPart(fractionPart);
    }

    @Override
    public int getIntegerPart() {
        return integerPart;
    }

    @Override
    public void setIntegerPart(int value) {
        this.integerPart = value;
    }

    @Override
    public ISimpleFraction getFractionPart() {
        return fractionPart;
    }

    @Override
    public void setFractionPart(ISimpleFraction value) {
        if (value.isImproper()) {
            throw new IllegalArgumentException();
        }

        this.fractionPart = value;
    }

    @Override
    public IFraction reciprocal() {
        return new SimpleFraction(integerPart * fractionPart.getDenominator() + fractionPart.getNumerator(), fractionPart.getDenominator()).reciprocal();
    }

    @Override
    public IFraction reduce() {
        return new SimpleFraction(integerPart * fractionPart.getDenominator() + fractionPart.getNumerator(), fractionPart.getDenominator()).reduce();
    }

    @Override
    public float floatValue() {
        return (float) integerPart + fractionPart.floatValue();
    }

    @Override
    public double doubleValue() {
        return (double) integerPart + fractionPart.doubleValue();
    }

    @Override
    public String toString() {
        return integerPart + " " + fractionPart.toString();
    }

    @Override
    public IFraction add(IFraction value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IFraction subtract(IFraction value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IFraction multiply(IFraction value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public IFraction multiply(int value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int compareTo(IFraction o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MixedNumber other = (MixedNumber) obj;
        if (this.integerPart != other.integerPart) {
            return false;
        }
        if (!Objects.equals(this.fractionPart, other.fractionPart)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }
}
