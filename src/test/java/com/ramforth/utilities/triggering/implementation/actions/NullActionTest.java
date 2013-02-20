/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.actions;

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
public class NullActionTest {
    
    public NullActionTest() {
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
     * Test of perform method, of class NullAction.
     */
    @Test
    public void testPerform() {
        System.out.println("perform");
        NullAction instance = new NullAction();
        instance.perform();
        assertTrue(true);
    }

    /**
     * Test of toString method, of class NullAction.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        NullAction instance = new NullAction();
        String expResult = "Nichts";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormatString method, of class NullAction.
     */
    @Test
    public void testGetFormatString() {
        System.out.println("getFormatString");
        NullAction instance = new NullAction();
        String expResult = "Nichts";
        String result = instance.getFormatString();
        assertEquals(expResult, result);
    }
}
