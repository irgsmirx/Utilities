/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.interfaces;

/**
 *
 * @author tobias
 */
public interface IEvent extends ITriggerChild {
    
    boolean occurred();
    void reset();
    
}
