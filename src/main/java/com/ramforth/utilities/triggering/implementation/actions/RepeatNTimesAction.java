/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.actions;

/**
 *
 * @author tobias
 */
public class RepeatNTimesAction extends AbstractUnaryAction {

    protected int n = 0;

    public int getN() {
        return n;
    }
    
    public void setN(int value) {
        this.n = value;
    }

    @Override
    public void perform() {
        for (int i = 0; i < n; i++) {
            childAction.perform();
        }
    }

    @Override
    public String toString() {
        return String.format("Repeat %s times: %s.", n, childAction.toString());
    }
    
    @Override
    public String getFormatString() {
        return "Repeat {n} times: {childAction}.";
    }

}
