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

import com.ramforth.utilities.triggering.interfaces.IEvent;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author tobias
 */
public class AbstractBinaryEventTest {

    public AbstractBinaryEventTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getLeftChildEvent method, of class AbstractBinaryEvent.
     */
    @Test
    public void testGetLeftChildEvent() {
        System.out.println("getLeftChildEvent");
        AbstractBinaryEvent instance = new AbstractBinaryEventImpl();
        IEvent leftChildEvent = new AbstractBinaryEventImpl();
        instance.setLeftChildEvent(leftChildEvent);
        IEvent expResult = leftChildEvent;
        IEvent result = instance.getLeftChildEvent();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLeftChildEvent method, of class AbstractBinaryEvent.
     */
    @Test
    public void testSetLeftChildEvent() {
        System.out.println("setLeftChildEvent");
        IEvent value = new AbstractBinaryEventImpl();
        AbstractBinaryEvent instance = new AbstractBinaryEventImpl();
        instance.setLeftChildEvent(value);
        assertEquals(value, instance.getLeftChildEvent());
    }

    /**
     * Test of getRightChildEvent method, of class AbstractBinaryEvent.
     */
    @Test
    public void testGetRightChildEvent() {
        System.out.println("getRightChildEvent");
        AbstractBinaryEvent instance = new AbstractBinaryEventImpl();
        IEvent rightChildEvent = new AbstractBinaryEventImpl();
        instance.setRigthChildEvent(rightChildEvent);
        IEvent expResult = rightChildEvent;
        IEvent result = instance.getRightChildEvent();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRigthChildEvent method, of class AbstractBinaryEvent.
     */
    @Test
    public void testSetRigthChildEvent() {
        System.out.println("setRigthChildEvent");
        IEvent value = new AbstractBinaryEventImpl();
        AbstractBinaryEvent instance = new AbstractBinaryEventImpl();
        instance.setRigthChildEvent(value);
        assertEquals(value, instance.getRightChildEvent());
    }

    /**
     * Test of reset method, of class AbstractBinaryEvent.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        AbstractBinaryEvent instance = new AbstractBinaryEventImpl();
        AbstractEventImpl leftChildEvent = new AbstractEventImpl();
        AbstractEventImpl rightChildEvent = new AbstractEventImpl();
        instance.setLeftChildEvent(leftChildEvent);
        instance.setRigthChildEvent(rightChildEvent);
        instance.reset();
        assertTrue(leftChildEvent.resetted);
        assertTrue(rightChildEvent.resetted);
    }

    public class AbstractEventImpl extends AbstractEvent {

        public boolean resetted = false;

        @Override
        public boolean occurred() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void reset() {
            resetted = true;
        }

        @Override
        public String getFormatString() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    public class AbstractBinaryEventImpl extends AbstractBinaryEvent {

        @Override
        public boolean occurred() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public String getFormatString() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
