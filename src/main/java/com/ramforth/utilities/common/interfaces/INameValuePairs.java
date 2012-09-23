/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.common.interfaces;

import com.ramforth.utilities.common.implementation.NameValuePair;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public interface INameValuePairs extends Iterable<NameValuePair> {
  
  void add(NameValuePair value);
  void add(String name, String value);
  void remove(NameValuePair value);
  void remove(String name);
  int numberOfPairs();
	void clear();
  boolean contains(NameValuePair value);
  boolean contains(String name);
  NameValuePair getAt(int index);
  String getValue(String name);
}
