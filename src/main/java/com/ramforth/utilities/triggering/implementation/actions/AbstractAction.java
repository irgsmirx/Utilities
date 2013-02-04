/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.actions;

import com.ramforth.utilities.triggering.implementation.AbstractTriggerChild;
import com.ramforth.utilities.triggering.interfaces.IAction;

/**
 *
 * @author tobias
 */
public abstract class AbstractAction extends AbstractTriggerChild implements IAction {

    @Override
    public abstract void perform();
    
}
