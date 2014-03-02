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
package com.ramforth.utilities.triggering.implementation.actions;

/**
 *
 * @author tobias
 */
public class RepeatNTimesAction extends AbstractUnaryAction {

    protected int n = 0;

    public int getN() {
        return n;
    }
    
    public void setN(int value) {
        this.n = value;
    }

    @Override
    public void perform() {
        for (int i = 0; i < n; i++) {
            childAction.perform();
        }
    }

    @Override
    public String toString() {
        return String.format("Repeat %s times: %s.", n, childAction.toString());
    }
    
    @Override
    public String getFormatString() {
        return "Repeat {n} times: {childAction}.";
    }

}
