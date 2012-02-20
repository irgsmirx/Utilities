/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fractions.interfaces;

/**
 *
 * @author Administrator
 */
public interface ISimpleFraction extends IFraction {
    
    int getNumerator();
    void setNumerator(int value);
    
    int getDenominator();
    void setDenominator(int denominator);
    
    boolean isProper();
    boolean isImproper();
    
}
