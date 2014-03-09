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
package com.ramforth.utilities.common.interfaces;

import com.ramforth.utilities.common.implementation.Pair;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 * @param <LEFT>
 * @param <RIGHT>
 */
public interface IPairs<LEFT, RIGHT> extends Iterable<IPair<LEFT, RIGHT>> {

    boolean add(IPair<LEFT, RIGHT> value);

    boolean add(LEFT left, RIGHT right);

    boolean addAll(Iterable<IPair<LEFT, RIGHT>> value);
    
    void remove(IPair<LEFT, RIGHT> value);

    void remove(LEFT left);

    int numberOfPairs();

    void clear();

    boolean contains(IPair<LEFT, RIGHT> value);

    boolean contains(LEFT left);

    IPair<LEFT, RIGHT> get(LEFT left);
    
    IPair<LEFT, RIGHT> getAt(int index);

    RIGHT getRight(LEFT left);
    
    void set(LEFT left, RIGHT right);
    
}
