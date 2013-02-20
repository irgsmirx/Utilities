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
public class FalseConditionTest {
    
    public FalseConditionTest() {
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
        FalseCondition instance = new FalseCondition();
        boolean expResult = false;
        boolean result = instance.isMet();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class TrueCondition.
     */
    @Test
    public void testToFormatString() {
        System.out.println("toString");
        FalseCondition instance = new FalseCondition();
        String expResult = "FALSE";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of getFormatString method, of class TrueCondition.
     */
    @Test
    public void testGetFormatString() {
        System.out.println("getFormatString");
        FalseCondition instance = new FalseCondition();
        String expResult = "FALSE";
        String result = instance.getFormatString();
        assertEquals(expResult, result);
    }
}
