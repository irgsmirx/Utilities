/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.common.implementation;

import java.util.Iterator;

/**
 *
 * @author tobias
 */
public class EmptyIterable<T> implements Iterable<T> {

  @Override
  public Iterator<T> iterator() {
    return new EmptyIterator<>();
  }
  
}
