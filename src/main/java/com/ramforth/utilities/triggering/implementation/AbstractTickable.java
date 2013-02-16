/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation;

import com.ramforth.utilities.triggering.interfaces.ITickable;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public abstract class AbstractTickable implements ITickable {
    
    protected long lastTickedMilliseconds = -1;
    
    @Override
    public boolean tick(long milliseconds) {
        this.lastTickedMilliseconds = milliseconds;
        return this.tick();
    }
    
}
