/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.events;

/**
 *
 * @author tobias
 */
public class NotEvent extends AbstractUnaryEvent {

    @Override
    public boolean occurred() {
        return !childEvent.occurred();
    }

    @Override
    public String toString() {
        return String.format("NOT (%s)", childEvent);
    }
    
    @Override
    public String getFormatString() {
        return "NOT ({childEvent})";
    }
   
}
