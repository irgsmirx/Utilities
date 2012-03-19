/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.common.interfaces;

/**
 *
 * @author Administrator
 */
public interface IComparable extends IEqualityComparable {
   
    boolean isGreaterThan(Object o);
    boolean isLessThan(Object o);
    
}
