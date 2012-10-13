/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.exceptions;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class URISyntaxException extends RuntimeException {

    public URISyntaxException() {
        super();
    }

    public URISyntaxException(String message) {
        super(message);
    }

    public URISyntaxException(String message, Throwable cause) {
        super(message, cause);
    }

    public URISyntaxException(Throwable cause) {
        super(cause);
    }

    public URISyntaxException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
