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
package com.ramforth.utilities.trees.binary.interfaces;

import com.ramforth.utilities.trees.interfaces.INode;

/**
 *
 * @author tobias
 */
public interface IBinaryNode extends INode {

    IBinaryNode getLeftChild();

    void setLeftChild(IBinaryNode value);

    IBinaryNode getRightChild();

    void setRightChild(IBinaryNode value);
}
