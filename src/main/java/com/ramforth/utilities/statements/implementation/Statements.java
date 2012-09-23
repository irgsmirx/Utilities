/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
