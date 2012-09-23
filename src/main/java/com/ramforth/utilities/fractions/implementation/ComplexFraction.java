/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.fractions.implementation;

import com.ramforth.utilities.fractions.interfaces.IComplexFraction;
import com.ramforth.utilities.fractions.interfaces.IFraction;
import java.util.Objects;

/**
 *
 * @author Administrator
 */
public final class ComplexFraction extends AbstractFraction implements IComplexFraction {

    protected IFraction numerator;
    protected IFraction denominator;

    public ComplexFraction(IFraction numerator, IFraction denominator) {
        setNumerator(numerator);
        setDenominator(denominator);
    }

    @Override
    public IFraction getNumerator() {
        return numerator;
    }

    @Override
    public void setNumerator(IFraction value) {
        this.numerator = value;
    }

    @Override
    public IFraction getDenominator() {
        return denominator;
    }

    @Override
    public void setDenominator(IFraction value) {
        this.denominator = value;
    }

    @Override
    public IFraction reciprocal() {
        return new ComplexFraction(denominator, numerator);
    }

    @Override
    public IFraction reduce() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public float floatValue() {
        return numerator.floatValue() / denominator.floatValue();
    }

    @Override
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    @Override
    public String toString() {
        return "(" + numerator.toString() + ") / (" + denominator.toString() + ")";
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
        final ComplexFraction other = (ComplexFraction) obj;
        if (!Objects.equals(this.numerator, other.numerator)) {
            return false;
        }
        if (!Objects.equals(this.denominator, other.denominator)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }
}
