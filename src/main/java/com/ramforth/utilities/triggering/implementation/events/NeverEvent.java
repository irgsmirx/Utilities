/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.events;

/**
 *
 * @author tobias
 */
public class NeverEvent extends AbstractEvent {

    @Override
    public boolean occurred() {
        return false;
    }

    @Override
    public String getFormatString() {
        return "NEVER";
    }
    
}
