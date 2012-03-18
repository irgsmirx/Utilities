/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common.interfaces;

/**
 *
 * @author tobias
 */
public interface IQueue<T> {
	
	int getLength();
  int numberOfTokens();

  void enqueue(T value);
  T dequeue();
  
  void clear();
  
  T getAt(int index);
	
}
