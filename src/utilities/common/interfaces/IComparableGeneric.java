/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.common.interfaces;

/**
 *
 * @author Administrator
 */
public interface IComparableGeneric<T> extends IEqualityComparableGeneric<T> {
    
    boolean isLessThan(T t);
    boolean isGreaterThan(T t);
    
}
