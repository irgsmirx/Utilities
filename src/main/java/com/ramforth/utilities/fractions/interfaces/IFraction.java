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
package com.ramforth.utilities.fractions.interfaces;

/**
 *
 * @author Administrator
 */
public interface IFraction extends Comparable<IFraction> {

    IFraction reduce();

    IFraction reciprocal();

    float floatValue();

    double doubleValue();

    IFraction add(IFraction value);

    IFraction subtract(IFraction value);

    IFraction multiply(IFraction value);

    IFraction multiply(int value);
}
