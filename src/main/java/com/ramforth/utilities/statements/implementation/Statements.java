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
package com.ramforth.utilities.statements.implementation;

import com.ramforth.utilities.statements.interfaces.IBlockStatement;
import com.ramforth.utilities.statements.interfaces.IVariableStatement;
import com.ramforth.utilities.statements.interfaces.IIncrementStatement;
import com.ramforth.utilities.statements.interfaces.IAssignmentStatement;
import com.ramforth.utilities.statements.interfaces.IIfStatement;
import com.ramforth.utilities.statements.interfaces.IStatement;
import com.ramforth.utilities.statements.interfaces.IDecrementStatement;
import com.ramforth.utilities.expressions.interfaces.IExpression;
import com.ramforth.utilities.expressions.interfaces.IParameterExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class Statements {

    public static IAssignmentStatement Assignment() {
        return new AssignmentStatement();
    }

    public static IIncrementStatement Increment(IParameterExpression target) {
        return new IncrementStatement(target);
    }

    public static IDecrementStatement Decrement(IParameterExpression target) {
        return new DecrementStatement(target);
    }

    public static IVariableStatement Variable(String name) {
        return new VariableStatement(name);
    }

    public static IBlockStatement Block(IStatement... statements) {
        return new BlockStatement(statements);
    }

    public static IIfStatement If(IExpression condition, IStatement thenStatement) {
        return new IfStatement(condition, thenStatement);
    }

    public static IIfStatement If(IExpression condition, IStatement thenStatement, IStatement elseStatement) {
        return new IfStatement(condition, thenStatement, elseStatement);
    }
}
