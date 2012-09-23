/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.common.implementation;

/**
 *
 * @author tobias
 */
public final class StringUtilities {
	
	public static final String EMPTY = "";

  public static boolean isNullOrEmpty(String value) {
    return value == null || value.isEmpty();
  }
  
  public static boolean isNullOrWhitespace(String value) {
    return value == null || value.trim().isEmpty();
  }
  
}
