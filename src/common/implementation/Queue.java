/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.implementation;

import common.interfaces.IQueue;

/**
 *
 * @author tobias
 */
public class Queue<T> implements IQueue<T> {

	private T[] tokens;
  private int numberOfTokens = 0;
  private int indexOfFirstToken = 0;
          
  public Queue() {
    tokens = (T[])new Object[2];
  }
  
  @Override
  public int getLength() {
    return tokens.length;
  }
  
  @Override
  public int numberOfTokens() {
    return numberOfTokens;
  }
  
  @Override
  public void enqueue(T token) {
    if (numberOfTokens == tokens.length) {
      T[] newTokens = (T[])new Object[tokens.length + 1];
      
			for (int i = 0; i < getLength(); i++) {
				newTokens[i] = getAt(i);
			}
			
      tokens = newTokens;
			indexOfFirstToken = 0;
    }
    
    tokens[(indexOfFirstToken + numberOfTokens) % getLength()] = token;
		numberOfTokens++;
  }
  
  @Override
  public T dequeue() {
    if (numberOfTokens == 0) {
      throw new QueueException();
    } else {
      T token = getAt(0);
			indexOfFirstToken = (indexOfFirstToken + 1) % getLength();
      numberOfTokens--;
			return token;
    }
  }
  
  @Override
  public void clear() {
    numberOfTokens = 0;
		indexOfFirstToken = 0;
  }
  
  @Override
  public T getAt(int index) {
    return tokens[(indexOfFirstToken + index) % getLength()];
  }
	
}
