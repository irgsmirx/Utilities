/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ramforth.utilities.validation;

/**
 *
 * @author tobias
 */
public abstract class AbstractMessage {
    
    protected String message;
    
    public AbstractMessage(String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
    
}
