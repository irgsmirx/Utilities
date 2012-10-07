/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.exceptions;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class NoSuchElementException extends RuntimeException {

    public NoSuchElementException() {
        super();
    }

    public NoSuchElementException(String message) {
        super(message);
    }

    public NoSuchElementException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchElementException(Throwable cause) {
        super(cause);
    }

    public NoSuchElementException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
