/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package money.interfaces;

import fractions.interfaces.IFraction;

/**
 *
 * @author Administrator
 */
public interface IExchangeRate {
    
    ICurrency getSourceCurrency();
    void setSourceCurrency(ICurrency value);
    
    ICurrency getTargetCurrency();
    void setTargetCurrency(ICurrency value);
    
    IFraction getRate();
    void setRate(IFraction value);
    
}
