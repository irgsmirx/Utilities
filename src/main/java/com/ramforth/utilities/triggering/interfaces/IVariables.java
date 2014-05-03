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

package com.ramforth.utilities.triggering.interfaces;

/**
 *
 * @author Tobias Ramforth
 */
public interface IVariables extends Iterable<IVariable> {
    
    void prepend(IVariable value);
    void append(IVariable value);
    void remove(IVariable value);
    IVariable removeAt(int index);
    
    void clear();
    
    int numberOfVariaböes();
    
}