/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.common.implementation;

import com.ramforth.utilities.common.interfaces.IPredicate;

/**
 *
 * @author tobias
 */
public abstract class AbstractPredicate<T> implements IPredicate<T> {

    @Override
    public boolean doesNotHold() {
        return !holds();
    }
}
