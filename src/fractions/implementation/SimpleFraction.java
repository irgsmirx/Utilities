/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fractions.implementation;

import fractions.interfaces.IFraction;
import fractions.interfaces.ISimpleFraction;

/**
 *
 * @author Administrator
 */
public final class SimpleFraction extends AbstractFraction implements ISimpleFraction {

    public static ISimpleFraction ONE = new SimpleFraction(1, 1);
    
    protected int numerator;
    protected int denominator;
    
    public SimpleFraction(int numerator, int denominator) {
        setNumerator(numerator);
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
        return (float)numerator / (float)denominator;
    }

    @Override
    public double doubleValue() {
        return (double)numerator / (double)denominator;
    }
    
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public IFraction add(IFraction value) {
        if (value instanceof ISimpleFraction) {
            ISimpleFraction simpleFraction = (ISimpleFraction)value;
            
            return new SimpleFraction(numerator * simpleFraction.getDenominator() + denominator * simpleFraction.getNumerator(), denominator * simpleFraction.getDenominator());
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public IFraction subtract(IFraction value) {
        if (value instanceof ISimpleFraction) {
            ISimpleFraction simpleFraction = (ISimpleFraction)value;
           
            return new SimpleFraction(numerator * simpleFraction.getDenominator() - denominator * simpleFraction.getNumerator(), denominator * simpleFraction.getDenominator());
        } else {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    @Override
    public IFraction multiply(IFraction value) {
        if (value instanceof ISimpleFraction) {
            ISimpleFraction simpleFraction = (ISimpleFraction)value;
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
            ISimpleFraction simpleFraction = (ISimpleFraction)o;
            
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
