/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fractions.implementation;

import fractions.interfaces.IFraction;
import fractions.interfaces.IMixedNumer;
import fractions.interfaces.ISimpleFraction;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public IFraction reduce() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public float floatValue() {
        return (float)integerPart + fractionPart.floatValue();
    }

    @Override
    public double doubleValue() {
        return (double)integerPart + fractionPart.doubleValue();
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
