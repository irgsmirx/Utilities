/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.fractions.interfaces;

/**
 *
 * @author Administrator
 */
public interface IFraction extends Comparable<IFraction> {
   
    IFraction reduce();
    IFraction reciprocal();
    
    float floatValue();
    double doubleValue();
    
    IFraction add(IFraction value);
    IFraction subtract(IFraction value);
    IFraction multiply(IFraction value);
    IFraction multiply(int value);
    
}
