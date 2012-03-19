/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.money.implementation;

import utilities.fractions.interfaces.IFraction;
import utilities.money.interfaces.ICurrency;
import utilities.money.interfaces.IExchangeRate;

/**
 *
 * @author Administrator
 */
public final class ExchangeRate implements IExchangeRate {

    private ICurrency sourceCurrency;
    private ICurrency targetCurrency;
    
    private IFraction rate;
    
    @Override
    public final ICurrency getSourceCurrency() {
        return sourceCurrency;
    }

    @Override
    public void setSourceCurrency(ICurrency value) {
        this.sourceCurrency = value;
    }

    @Override
    public final ICurrency getTargetCurrency() {
        return targetCurrency;
    }

    @Override
    public void setTargetCurrency(ICurrency value) {
        this.targetCurrency = value;
    }

    @Override
    public final IFraction getRate() {
        return rate;
    }

    @Override
    public void setRate(IFraction value) {
        this.rate = value;
    }
    
}
