/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.money.interfaces;

/**
 *
 * @author Administrator
 */
public interface IMoney {
    
    int getAmount();
    void setAmount(int value);
    
    ICurrency getCurrency();
    void setCurrency(ICurrency value);
    
}
