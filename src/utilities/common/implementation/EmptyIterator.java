/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.common.implementation;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author tobias
 */
public class EmptyIterator<T> implements Iterator<T> {

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public T next() {
    throw new NoSuchElementException("");
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException("Not supported.");
  }
  
}
