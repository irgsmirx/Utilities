/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package money.interfaces;

/**
 *
 * @author Administrator
 */
public interface IComplexFraction extends IFraction {
    
    IFraction getNumerator();
    void setNumerator(IFraction value);
    
    IFraction getDenominator();
    void setDenominator(IFraction value);
    
}
