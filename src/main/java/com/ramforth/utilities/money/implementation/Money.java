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

import com.ramforth.utilities.money.interfaces.ICurrency;
import com.ramforth.utilities.money.interfaces.IMoney;

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
