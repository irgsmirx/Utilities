/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.variables;

import com.ramforth.utilities.triggering.implementation.AbstractTriggerChild;
import com.ramforth.utilities.triggering.interfaces.IVariable;

/**
 *
 * @author tobias
 */
public abstract class AbstractVariable extends AbstractTriggerChild  implements IVariable {
    
    protected String name;
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String value) {
        this.name = value;
    }
    
}
