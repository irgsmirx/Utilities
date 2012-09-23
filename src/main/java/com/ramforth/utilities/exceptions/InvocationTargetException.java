/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.exceptions;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class InvocationTargetException extends RuntimeException {

    public InvocationTargetException() {
        super();
    }

    public InvocationTargetException(String message) {
        super(message);
    }

    public InvocationTargetException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvocationTargetException(Throwable cause) {
        super(cause);
    }

    public InvocationTargetException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
