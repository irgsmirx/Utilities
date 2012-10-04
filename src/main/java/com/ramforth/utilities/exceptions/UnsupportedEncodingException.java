/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.exceptions;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class UnsupportedEncodingException extends RuntimeException {

    public UnsupportedEncodingException() {
    }

    public UnsupportedEncodingException(String message) {
        super(message);
    }

    public UnsupportedEncodingException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsupportedEncodingException(Throwable cause) {
        super(cause);
    }

    public UnsupportedEncodingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
