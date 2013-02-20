/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.actions;

/**
 *
 * @author tobias
 */
public class RunNTimesAction extends AbstractUnaryAction {

    protected int ranNTimesAlready = 0;
    protected int n = 0;

    public int getN() {
        return n;
    }
    
    public void setN(int value) {
        this.n = value;
    }

    @Override
    public void perform() {
        if (ranNTimesAlready < n) {
            childAction.perform();
            ranNTimesAlready++;
        }
    }

    @Override
    public String toString() {
        return String.format("Run %s times: %s.", n, childAction.toString());
    }
    
    @Override
    public String getFormatString() {
        return "Run {n} times: {childAction}.";
    }

}
