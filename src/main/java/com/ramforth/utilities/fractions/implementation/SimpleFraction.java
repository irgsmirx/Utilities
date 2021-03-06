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
import com.ramforth.utilities.fractions.interfaces.ISimpleFraction;

/**
 *
 * @author Administrator
 */
public final class SimpleFraction extends AbstractFraction implements ISimpleFraction {

    public static ISimpleFraction ONE = new SimpleFraction(1, 1);
    public static ISimpleFraction HALF = new SimpleFraction(1, 2);
    public static ISimpleFraction THIRD = new SimpleFraction(1, 3);
    public static ISimpleFraction TWO_THIRDS = new SimpleFraction(2, 3);
    public static ISimpleFraction QUARTER = new SimpleFraction(1, 4);
    public static ISimpleFraction THREE_QUARTERS = new SimpleFraction(3, 4);
    protected int numerator;
    protected int denominator;

    public SimpleFraction(int numerator, int denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    public SimpleFraction(int wholeIntegers, int numerator, int denominator) {
        setNumerator(wholeIntegers * denominator + numerator);
        setDenominator(denominator);
    }

    @Override
    public int getNumerator() {
        return numerator;
    }

    @Override
    public void setNumerator(int value) {
        this.numerator = value;
    }

    @Override
    public int getDenominator() {
        return denominator;
    }

    @Override
    public void setDenominator(int value) {
        if (value == 0) {
            throw new DivisionByZeroException();
        }
        this.denominator = value;
    }

    @Override
    public boolean isProper() {
        return numerator < denominator;
    }

    @Override
    public boolean isImproper() {
        return !isProper();
    }

    @Override
    public IFraction reciprocal() {
        return new SimpleFraction(denominator, numerator);
    }

    @Override
    public IFraction reduce() {
        int greatestCommonDivisor = greatestCommonDivisorEuclid(numerator, denominator);

        IFraction reduced = new SimpleFraction(numerator / greatestCommonDivisor, denominator / greatestCommonDivisor);

        return reduced;
    }

    @Override
    public float floatValue() {
        return (float) numerator / (float) denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / (double) denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public String toMixedString() {
        return ( numerator / denominator ) + " " + ( numerator % denominator ) + "/" + denominator;
    }

    @Override
    public IFraction add(IFraction value) {
        if (value instanceof ISimpleFraction) {
            ISimpleFraction simpleFraction = (ISimpleFraction) value;

            return new SimpleFraction(numerator * simpleFraction.getDenominator() + denominator * simpleFraction.getNumerator(), denominator * simpleFraction.getDenominator());
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public IFraction subtract(IFraction value) {
        if (value instanceof ISimpleFraction) {
            ISimpleFraction simpleFraction = (ISimpleFraction) value;

            return new SimpleFraction(numerator * simpleFraction.getDenominator() - denominator * simpleFraction.getNumerator(), denominator * simpleFraction.getDenominator());
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public IFraction multiply(IFraction value) {
        if (value instanceof ISimpleFraction) {
            ISimpleFraction simpleFraction = (ISimpleFraction) value;
            return new SimpleFraction(numerator * simpleFraction.getNumerator(), denominator * simpleFraction.getDenominator());
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public IFraction multiply(int value) {
        return new SimpleFraction(numerator * value, denominator);
    }

    @Override
    public int compareTo(IFraction o) {
        if (o instanceof ISimpleFraction) {
            ISimpleFraction simpleFraction = (ISimpleFraction) o;

            if (denominator == simpleFraction.getDenominator()) {
                return numerator - simpleFraction.getNumerator();
            } else {
                return numerator * simpleFraction.getDenominator() - denominator * simpleFraction.getNumerator();
            }
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SimpleFraction other = (SimpleFraction) obj;

        return compareTo(other) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }
}
