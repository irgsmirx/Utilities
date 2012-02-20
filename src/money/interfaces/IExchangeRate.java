/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package money.interfaces;

/**
 *
 * @author Administrator
 */
public interface IExchangeRate {
    
    ICurrency getSourceCurrency();
    void setSourceCurrency(ICurrency value);
    
    ICurrency getTargetCurrency();
    void setTargetCurrency(ICurrency value);
    
}
