/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.common.interfaces;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public interface IQueue<T> {
  
  int getLength();
  int numberOfElements();

  void enqueue(T value);
  T dequeue();
  
  void clear();
  
  T getAt(int index);
  
}
