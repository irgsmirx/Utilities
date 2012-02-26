/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.implementation;

import common.interfaces.IPredicate;

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
