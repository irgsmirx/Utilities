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
public class AbstractEventTest {
    
    public AbstractEventTest() {
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
     * Test of occurred method, of class AbstractEvent.
     */
    @Test
    public void testOccurred() {
        System.out.println("occurred");
        AbstractEvent instance = new AbstractEventImpl();
        boolean expResult = true;
        boolean result = instance.occurred();
        assertEquals(expResult, result);
    }

    /**
     * Test of reset method, of class AbstractEvent.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        AbstractEventImpl instance = new AbstractEventImpl();
        instance.reset();
        assertTrue(instance.resetted);
    }

    public class AbstractEventImpl extends AbstractEvent {

        public boolean resetted = false;
        
        @Override
        public boolean occurred() {
            return true;
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
}
