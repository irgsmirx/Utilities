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

import com.ramforth.utilities.expressions.interfaces.IExpression;
import com.ramforth.utilities.statements.interfaces.IIfStatement;
import com.ramforth.utilities.statements.interfaces.IStatement;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IfStatement extends AbstractStatement implements IIfStatement {

    private IExpression condition;
    private IStatement thenStatement;
    private IStatement elseStatement;

    public IfStatement(IExpression condition, IStatement thenStatement) {
        this.condition = condition;
        this.thenStatement = thenStatement;
    }

    public IfStatement(IExpression condition, IStatement thenStatement, IStatement elseStatement) {
        this(condition, thenStatement);
        this.elseStatement = elseStatement;
    }

    @Override
    public IExpression getCondition() {
        return condition;
    }

    @Override
    public void setCondition(IExpression value) {
        this.condition = value;
    }

    @Override
    public IStatement getThen() {
        return thenStatement;
    }

    @Override
    public void setThen(IStatement value) {
        this.thenStatement = value;
    }

    @Override
    public IStatement getElse() {
        return elseStatement;
    }

    @Override
    public void setElse(IStatement value) {
        this.elseStatement = value;
    }
}
