/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package money.implementation;

import money.interfaces.ICurrency;

/**
 *
 * @author Administrator
 */
public final class Currency implements ICurrency {

    private String name;
    private String abbreviation;
    private String symbol;
    
    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public final String getSymbol() {
        return symbol;
    }
    
}
