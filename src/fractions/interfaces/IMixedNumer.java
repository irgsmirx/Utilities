/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fractions.interfaces;

/**
 *
 * @author Administrator
 */
public interface IMixedNumer extends IFraction {
    
    int getIntegerPart();
    void setIntegerPart(int value);
    
    ISimpleFraction getFractionPart();
    void setFractionPart(ISimpleFraction value);
    
}
