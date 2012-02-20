/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fractions.implementation;

import fractions.interfaces.IComplexFraction;
import fractions.interfaces.IFraction;

/**
 *
 * @author Administrator
 */
public final class ComplexFraction extends AbstractFraction implements IComplexFraction {

    protected IFraction numerator;
    protected IFraction denominator;

    public ComplexFraction(IFraction numerator, IFraction denominator) {
        setNumerator(numerator);
        setDenominator(numerator);
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
    
}
