/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.expressions.implementation;

import com.ramforth.utilities.expressions.interfaces.IExpression;
import com.ramforth.utilities.expressions.interfaces.INorExpression;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class NorExpression extends AbstractConditionalExpression implements INorExpression {

    public NorExpression(IExpression leftChild, IExpression rightChild) {
        super(leftChild, rightChild);
    }
    
    @Override
    public String toString() {
        return String.format("(%s NOR %s)", leftChild, rightChild);
    }
    
}
