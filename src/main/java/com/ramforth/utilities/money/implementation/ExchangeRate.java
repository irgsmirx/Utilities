/* 
 * Copyright (C) 2014 Tobias Ramforth
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ramforth.utilities.money.implementation;

import com.ramforth.utilities.fractions.interfaces.IFraction;
import com.ramforth.utilities.money.interfaces.ICurrency;
import com.ramforth.utilities.money.interfaces.IExchangeRate;

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
