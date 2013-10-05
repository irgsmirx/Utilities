/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.expressions.writers.implementation;

import com.ramforth.utilities.expressions.interfaces.IAddExpression;
import com.ramforth.utilities.expressions.interfaces.IAndExpression;
import com.ramforth.utilities.expressions.interfaces.IBinaryExpression;
import com.ramforth.utilities.expressions.interfaces.IConditionalExpression;
import com.ramforth.utilities.expressions.interfaces.IConstantExpression;
import com.ramforth.utilities.expressions.interfaces.IDivideExpression;
import com.ramforth.utilities.expressions.interfaces.IEqualExpression;
import com.ramforth.utilities.expressions.interfaces.IExpression;
import com.ramforth.utilities.expressions.writers.interfaces.IExpressionWriter;
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
public class ExpressionWriter implements IExpressionWriter {

    protected StringBuilder sb;
    
    public ExpressionWriter() {
        sb = new StringBuilder();
    }
    
        @Override
    public void write(IExpression expression) {
        if (expression instanceof IConstantExpression) {
            write((IConstantExpression) expression);
        } else if (expression instanceof IEqualExpression) {
            write((IEqualExpression) expression);
        } else if (expression instanceof INotEqualExpression) {
            write((INotEqualExpression) expression);
        } else if (expression instanceof INotExpression) {
            write((INotExpression) expression);
        } else if (expression instanceof ILessThanExpression) {
            write((ILessThanExpression) expression);
        } else if (expression instanceof IGreaterThanExpression) {
            write((IGreaterThanExpression) expression);
        } else if (expression instanceof ILessOrEqualExpression) {
            write((ILessOrEqualExpression) expression);
        } else if (expression instanceof IGreaterOrEqualExpression) {
            write((IGreaterOrEqualExpression) expression);
        } else if (expression instanceof IAndExpression) {
            write((IAndExpression) expression);
        } else if (expression instanceof IOrExpression) {
            write((IOrExpression) expression);
        } else if (expression instanceof INorExpression) {
            write((INorExpression) expression);
        } else if (expression instanceof IXorExpression) {
            write((IXorExpression) expression);
        } else if (expression instanceof INotExpression) {
            write((INotExpression) expression);
        } else if (expression instanceof IConstantExpression) {
            write((IConstantExpression)expression);
        } else if (expression instanceof INegateExpression) {
            write((INegateExpression)expression);
        } else if (expression instanceof IAddExpression) {
            write((IAddExpression)expression);
        } else if (expression instanceof ISubtractExpression) {
            write((ISubtractExpression)expression);
        } else if (expression instanceof IMultiplyExpression) {
            write((IMultiplyExpression)expression);
        } else if (expression instanceof IDivideExpression) {
            write((IDivideExpression)expression);
        } else if (expression instanceof IModuloExpression) {
            write((IModuloExpression)expression);
        }
    }
    
    @Override
    public void write(IAddExpression expression) {
        write(expression.getLeftChild());
        sb.append(" + ");
        write(expression.getRightChild());
    }

    @Override
    public void write(IAndExpression expression) {
        sb.append("(");
        write(expression.getLeftChild());
        sb.append(" AND ");
        write(expression.getRightChild());
        sb.append(")");
    }

    @Override
    public void write(IBinaryExpression expression) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void write(IConditionalExpression expression) {
        if (expression instanceof IEqualExpression) {
            write((IEqualExpression)expression);
        } else if (expression instanceof INotEqualExpression) {
            write((INotEqualExpression)expression);
        } else if (expression instanceof ILessThanExpression) {
            write((ILessThanExpression)expression);
        } else if (expression instanceof ILessOrEqualExpression) {
            write((ILessOrEqualExpression)expression);
        } else if (expression instanceof IGreaterThanExpression) {
            write((IGreaterThanExpression)expression);
        } else if (expression instanceof IGreaterOrEqualExpression) {
            write((IGreaterOrEqualExpression)expression);
        }
    }

    @Override
    public void write(IDivideExpression expression) {
        write(expression.getLeftChild());
        sb.append(" / ");
        write(expression.getRightChild());        
    }

    @Override
    public void write(IEqualExpression expression) {
        write(expression.getLeftChild());
        sb.append(" = ");
        write(expression.getRightChild());
    }

    @Override
    public void write(IGreaterOrEqualExpression expression) {
        write(expression.getLeftChild());
        sb.append(" >= ");
        write(expression.getRightChild());
    }

    @Override
    public void write(IGreaterThanExpression expression) {
        write(expression.getLeftChild());
        sb.append(" > ");
        write(expression.getRightChild());
    }

    @Override
    public void write(ILessOrEqualExpression expression) {
        write(expression.getLeftChild());
        sb.append(" <= ");
        write(expression.getRightChild());
    }

    @Override
    public void write(ILessThanExpression expression) {
        write(expression.getLeftChild());
        sb.append(" < ");
        write(expression.getRightChild());
    }

    @Override
    public void write(IModuloExpression expression) {
        write(expression.getLeftChild());
        sb.append(" % ");
        write(expression.getRightChild());
    }

    @Override
    public void write(IMultiplyExpression expression) {
        write(expression.getLeftChild());
        sb.append(" * ");
        write(expression.getRightChild());    
    }

    @Override
    public void write(INegateExpression expression) {
        sb.append("(");
        sb.append("-");
        write(expression.getChild());
        sb.append(")");
    }

    @Override
    public void write(INorExpression expression) {
        sb.append("(");
        write(expression.getLeftChild());
        sb.append(" NOR ");
        write(expression.getRightChild());
        sb.append(")");
    }

    @Override
    public void write(INotEqualExpression expression) {
        write(expression.getLeftChild());
        sb.append(" != ");
        write(expression.getRightChild());
    }

    @Override
    public void write(INotExpression expression) {
        sb.append("NOT(");
        write(expression.getChild());
        sb.append(")");
    }
    
    @Override
    public void write(IOrExpression expression) {
        sb.append("(");
        write(expression.getLeftChild());
        sb.append(" OR ");
        write(expression.getRightChild());    
        sb.append(")");
    }

    @Override
    public void write(IParameterExpression expression) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void write(IParenthesizedExpression expression) {
        sb.append("(");
        write(expression.getChild());
        sb.append(")");
    }

    @Override
    public void write(IPowerExpression expression) {
        write(expression.getLeftChild());
        sb.append("^");
        write(expression.getRightChild());
    }

    @Override
    public void write(IPropertyExpression expression) {
        write(expression.getTarget());
        sb.append(".");
        sb.append(expression.getPropertyName());
    }

    @Override
    public void write(ISubtractExpression expression) {
        write(expression.getLeftChild());
        sb.append(" - ");
        write(expression.getRightChild());    }

    @Override
    public void write(IUnaryExpression expression) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void write(IXorExpression expression) {
        sb.append("(");
        write(expression.getLeftChild());
        sb.append(" XOR ");
        write(expression.getRightChild());
        sb.append(")");
    }
    
    @Override
    public void write(IConstantExpression constantExpression) {
        sb.append(constantExpression.getValue().toString());
    }
    
    @Override
    public String toString() {
        return sb.toString();
    }
    
}
