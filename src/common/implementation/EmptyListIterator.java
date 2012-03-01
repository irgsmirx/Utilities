/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.implementation;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 *
 * @author tobias
 */
public class EmptyListIterator<T> implements ListIterator<T> {

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public T next() {
    throw new NoSuchElementException();
  }

  @Override
  public boolean hasPrevious() {
    return false;
  }

  @Override
  public T previous() {
    throw new NoSuchElementException();
  }

  @Override
  public int nextIndex() {
    return 0;
  }

  @Override
  public int previousIndex() {
    return -1;
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public void set(T e) {
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public void add(T e) {
    throw new UnsupportedOperationException("Not supported.");
  }
  
}
