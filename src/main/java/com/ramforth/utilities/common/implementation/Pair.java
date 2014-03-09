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
package com.ramforth.utilities.common.implementation;

import com.ramforth.utilities.common.interfaces.IPair;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 * @param <LEFT>
 * @param <RIGHT>
 */
public class Pair<LEFT, RIGHT> implements IPair<LEFT, RIGHT> {

    private LEFT left;
    private RIGHT right;

    public Pair(LEFT left, RIGHT right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public LEFT getLeft() {
        return left;
    }

    @Override
    public void setLeft(LEFT value) {
        this.left = value;
    }

    @Override
    public RIGHT getRight() {
        return right;
    }

    @Override
    public void setRight(RIGHT value) {
        this.right = value;
    }
    
}
