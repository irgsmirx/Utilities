/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class AbstractTickableTest {
    
    public AbstractTickableTest() {
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
     * Test of tick method, of class AbstractTickable.
     */
    @Test
    public void testTick() {
        System.out.println("tick");
        long milliseconds = 123L;
        AbstractTickableImpl instance = new AbstractTickableImpl();
        boolean expResult = true;
        boolean result = instance.tick(milliseconds);
        assertEquals(expResult, instance.ticked);
        assertEquals(milliseconds, instance.lastTickedMilliseconds);
    }

    public class AbstractTickableImpl extends AbstractTickable {

        public boolean ticked = false;
        
        @Override
        public boolean tick() {
            this.ticked = true;
            return ticked;
        }
        
    }
}
