/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.exceptions;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class ExceptionInInitializerError extends RuntimeException {

    public ExceptionInInitializerError() {
        super();
    }

    public ExceptionInInitializerError(String message) {
        super(message);
    }

    public ExceptionInInitializerError(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionInInitializerError(Throwable cause) {
        super(cause);
    }

    public ExceptionInInitializerError(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
