/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.interfaces;

/**
 *
 * @author tobias
 */
public interface IPredicate<T> {
	
	boolean holds();
	boolean doesNotHold();
	
}
