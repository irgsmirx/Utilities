/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.common.implementation;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author tobias
 */
public class EmptyList<T> implements List<T> {

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public Iterator<T> iterator() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public Object[] toArray() {
    return new Object[0];
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return (T[])new Object[0];
  }

  @Override
  public boolean add(T e) {
    return false;
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    return false;
  }

  @Override
  public boolean addAll(int index, Collection<? extends T> c) {
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return false;
  }

  @Override
  public void clear() {
  }

  @Override
  public T get(int index) {
    throw new IndexOutOfBoundsException();
  }

  @Override
  public T set(int index, T element) {
    throw new IndexOutOfBoundsException();
  }

  @Override
  public void add(int index, T element) {
    throw new IndexOutOfBoundsException();
  }

  @Override
  public T remove(int index) {
    throw new IndexOutOfBoundsException();
  }

  @Override
  public int indexOf(Object o) {
    return -1;
  }

  @Override
  public int lastIndexOf(Object o) {
    return -1;
  }

  @Override
  public ListIterator<T> listIterator() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public ListIterator<T> listIterator(int index) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public List<T> subList(int fromIndex, int toIndex) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
}
