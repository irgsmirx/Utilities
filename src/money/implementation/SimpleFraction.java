/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package money.implementation;

import money.interfaces.IFraction;
import money.interfaces.ISimpleFraction;

/**
 *
 * @author Administrator
 */
public class SimpleFraction extends AbstractFraction implements ISimpleFraction {

    protected int numerator;
    protected int denominator;
    
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
    
    public IFraction reduce() {
        IFraction reduced = new SimpleFraction();
        
        
        
        return reduced;
    }
    
}
