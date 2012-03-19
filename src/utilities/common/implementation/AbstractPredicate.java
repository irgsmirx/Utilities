/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.common.implementation;

import utilities.common.interfaces.IPredicate;

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
