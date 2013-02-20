/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.conditions;

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
public class TrueConditionTest {
    
    public TrueConditionTest() {
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
     * Test of isMet method, of class TrueCondition.
     */
    @Test
    public void testIsMet() {
        System.out.println("isMet");
        TrueCondition instance = new TrueCondition();
        boolean expResult = true;
        boolean result = instance.isMet();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class TrueCondition.
     */
    @Test
    public void testToFormatString() {
        System.out.println("toString");
        TrueCondition instance = new TrueCondition();
        String expResult = "TRUE";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of getFormatString method, of class TrueCondition.
     */
    @Test
    public void testGetFormatString() {
        System.out.println("getFormatString");
        TrueCondition instance = new TrueCondition();
        String expResult = "TRUE";
        String result = instance.getFormatString();
        assertEquals(expResult, result);
    }
}
