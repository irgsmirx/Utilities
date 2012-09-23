/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.regexp.implementation;

import com.ramforth.utilities.regexp.interfaces.IRegexpMatcher;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class RegexpMatcher implements IRegexpMatcher {

  private String value;
  private int valueLength;
  private int currentPosition = -1;
  
 
  public RegexpMatcher(String value) {
    this.value = value;
    this.valueLength = value.length();
  } 
 
  private int nextCharacter() {
    return value.codePointAt(currentPosition++);
  }
  
  @Override
  public IRegexpMatcher alpha() {
    if (!Character.isAlphabetic(nextCharacter())) {
      throw new RegexpDoesNotMatchException();
    }
    return this;
  }

  @Override
  public IRegexpMatcher numeric() {
    if (!Character.isDigit(nextCharacter())) {
      throw new RegexpDoesNotMatchException();
    }
    return this;
  }

  @Override
  public IRegexpMatcher alphaNumeric() {
    int nextCharacter = nextCharacter();
    
    if (!Character.isAlphabetic(nextCharacter) && !Character.isDigit(nextCharacter)) {
      throw new RegexpDoesNotMatchException();
    }
    return this;
  }

  @Override
  public IRegexpMatcher space() {
    if (!Character.isSpaceChar(nextCharacter())) {
      throw new RegexpDoesNotMatchException();
    }
    return this;
  }

  @Override
  public IRegexpMatcher tab() {
    return this;
  }

  @Override
  public IRegexpMatcher carriageReturn() {
    return this;
  }

  @Override
  public IRegexpMatcher newLine() {
    return this;
  }
  
}
