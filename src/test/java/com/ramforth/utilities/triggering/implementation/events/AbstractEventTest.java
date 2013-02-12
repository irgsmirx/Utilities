/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
