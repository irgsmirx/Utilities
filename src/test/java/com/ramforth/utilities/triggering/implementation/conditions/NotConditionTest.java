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
public class NotConditionTest {
    
    public NotConditionTest() {
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
     * Test of isMet method, of class NotCondition.
     */
    @Test
    public void testIsMet() {
        System.out.println("isMet");
        TrueCondition tc = new TrueCondition();
        NotCondition instance = new NotCondition();
        instance.childCondition = tc;
        boolean expResult = false;
        boolean result = instance.isMet();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class NotCondition.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TrueCondition tc = new TrueCondition();
        NotCondition instance = new NotCondition();
        instance.childCondition = tc;
        String expResult = "NOT(" + tc.toString() + ")";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormatString method, of class NotCondition.
     */
    @Test
    public void testGetFormatString() {
        System.out.println("getFormatString");
        NotCondition instance = new NotCondition();
        String expResult = "NOT({childCondition})";
        String result = instance.getFormatString();
        assertEquals(expResult, result);
    }
}
