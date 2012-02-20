/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package money.implementation;

import money.interfaces.IComplexFraction;
import money.interfaces.IFraction;

/**
 *
 * @author Administrator
 */
public class ComplexFraction extends AbstractFraction implements IComplexFraction {

    protected IFraction numerator;
    protected IFraction denominator;

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
    public IFraction reduce() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
