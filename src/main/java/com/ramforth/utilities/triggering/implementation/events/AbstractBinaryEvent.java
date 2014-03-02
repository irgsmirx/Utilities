/* 
 * Copyright (C) 2014 Tobias Ramforth
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ramforth.utilities.triggering.implementation.events;

import com.ramforth.utilities.triggering.events.IBinaryEvent;
import com.ramforth.utilities.triggering.interfaces.IEvent;

/**
 *
 * @author tobias
 */
public abstract class AbstractBinaryEvent extends AbstractEvent implements IBinaryEvent {
    
    protected IEvent leftChildEvent;
    protected IEvent rightChildEvent;
    
    @Override
    public IEvent getLeftChildEvent() {
        return leftChildEvent;
    }
    
    @Override
    public void setLeftChildEvent(IEvent value) {
        this.leftChildEvent = value;
    }
    
    @Override
    public IEvent getRightChildEvent() {
        return rightChildEvent;
    }
    
    @Override
    public void setRigthChildEvent(IEvent value) {
        this.rightChildEvent = value;
    }
    
    @Override
    public void reset() {
        leftChildEvent.reset();
        rightChildEvent.reset();
    }
    
}
