/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package money.implementation;

import money.interfaces.ICurrency;
import money.interfaces.IMoney;

/**
 *
 * @author Administrator
 */
public final class Money implements IMoney {

    private int amount;
    private ICurrency currency;
    
    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int value) {
        this.amount = value;
    }

    @Override
    public ICurrency getCurrency() {
        return currency;
    }

    @Override
    public void setCurrency(ICurrency value) {
        this.currency = value;
    }
    
}
