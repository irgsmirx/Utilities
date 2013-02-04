/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.actions;

import com.ramforth.utilities.triggering.interfaces.IAction;

/**
 *
 * @author tobias
 */
public abstract class AbstractUnaryAction extends AbstractAction {
    
    protected IAction childAction;
    
    public IAction getChildAction() {
        return childAction;
    }
    
    public void setchildAction(IAction value) {
        this.childAction = value;
    }
    
}
