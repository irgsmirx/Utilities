/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.common.interfaces;

/**
 *
 * @author tobias
 */
public interface IPredicate<T> {
	
	boolean holds();
	boolean doesNotHold();
	
}