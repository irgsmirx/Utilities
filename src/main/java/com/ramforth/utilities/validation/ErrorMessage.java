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
public class ErrorMessage extends AbstractMessage {
    
    public ErrorMessage(String message) {
        super(message);
    }
    
    @Override
    public String toString() {
        return String.format("ERROR! %1s", getMessage());
    }
    
}
