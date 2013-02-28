/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.expressions.writers.interfaces;

import com.ramforth.utilities.expressions.interfaces.IAddExpression;
import com.ramforth.utilities.expressions.interfaces.IAndExpression;
import com.ramforth.utilities.expressions.interfaces.IBinaryExpression;
import com.ramforth.utilities.expressions.interfaces.IConditionalExpression;
import com.ramforth.utilities.expressions.interfaces.IConstantExpression;
import com.ramforth.utilities.expressions.interfaces.IDivideExpression;
import com.ramforth.utilities.expressions.interfaces.IEqualExpression;
import com.ramforth.utilities.expressions.interfaces.IExpression;
import com.ramforth.utilities.expressions.interfaces.IGreaterOrEqualExpression;
import com.ramforth.utilities.expressions.interfaces.IGreaterThanExpression;
import com.ramforth.utilities.expressions.interfaces.ILessOrEqualExpression;
import com.ramforth.utilities.expressions.interfaces.ILessThanExpression;
import com.ramforth.utilities.expressions.interfaces.IModuloExpression;
import com.ramforth.utilities.expressions.interfaces.IMultiplyExpression;
import com.ramforth.utilities.expressions.interfaces.INegateExpression;
import com.ramforth.utilities.expressions.interfaces.INorExpression;
import com.ramforth.utilities.expressions.interfaces.INotEqualExpression;
import com.ramforth.utilities.expressions.interfaces.INotExpression;
import com.ramforth.utilities.expressions.interfaces.IOrExpression;
import com.ramforth.utilities.expressions.interfaces.IParameterExpression;
import com.ramforth.utilities.expressions.interfaces.IParenthesizedExpression;
import com.ramforth.utilities.expressions.interfaces.IPowerExpression;
import com.ramforth.utilities.expressions.interfaces.IPropertyExpression;
import com.ramforth.utilities.expressions.interfaces.ISubtractExpression;
import com.ramforth.utilities.expressions.interfaces.IUnaryExpression;
import com.ramforth.utilities.expressions.interfaces.IXorExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public interface IExpressionWriter {
    
    void write(IAddExpression expression);
    void write(IAndExpression expression);
    void write(IBinaryExpression expression);
    void write(IConditionalExpression expression);
    void write(IDivideExpression expression);
    void write(IEqualExpression expression);
    void write(IExpression expression);
    void write(IGreaterOrEqualExpression expression);
    void write(IGreaterThanExpression expression);
    void write(ILessOrEqualExpression expression);
    void write(ILessThanExpression expression);
    void write(IModuloExpression expression);
    void write(IMultiplyExpression expression);
    void write(INegateExpression expression);
    void write(INorExpression expression);
    void write(INotEqualExpression expression);
    void write(INotExpression expression);
    void write(IOrExpression expression);
    void write(IParameterExpression expression);
    void write(IParenthesizedExpression expression);
    void write(IPowerExpression expression);
    void write(IPropertyExpression expression);
    void write(ISubtractExpression expression);
    void write(IUnaryExpression expression);
    void write(IXorExpression expression);
    void write(IConstantExpression expression);
    
    @Override
    String toString();
        
}
