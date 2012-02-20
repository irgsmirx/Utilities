/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.interfaces;

/**
 *
 * @author Administrator
 */
public interface IComparable extends IEqualityComparable {
   
    boolean isGreaterThan(Object o);
    boolean isLessThan(Object o);
    
}
