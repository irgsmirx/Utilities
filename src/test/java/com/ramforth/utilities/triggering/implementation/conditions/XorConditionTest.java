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
public class XorConditionTest {
    
    public XorConditionTest() {
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
     * Test of isMet method, of class XorCondition.
     */
    @Test
    public void testTrueXorFalseIsMet() {
        System.out.println("isMet (true ^ false)");
        TrueCondition tc = new TrueCondition();
        FalseCondition fc = new FalseCondition();
        XorCondition instance = new XorCondition();
        instance.leftChildCondition = tc;
        instance.rightChildCondition = fc;
        boolean expResult = true;
        boolean result = instance.isMet();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isMet method, of class AndCondition.
     */
    @Test
    public void testFalseXorFalseIsMet() {
        System.out.println("isMet (false ^ false)");
        FalseCondition fc1 = new FalseCondition();
        FalseCondition fc2 = new FalseCondition();
        XorCondition instance = new XorCondition();
        instance.leftChildCondition = fc1;
        instance.rightChildCondition = fc2;
        boolean expResult = false;
        boolean result = instance.isMet();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isMet method, of class AndCondition.
     */
    @Test
    public void testTrueXorTrueIsMet() {
        System.out.println("isMet (true ^ true)");
        TrueCondition tc1 = new TrueCondition();
        TrueCondition tc2 = new TrueCondition();
        XorCondition instance = new XorCondition();
        instance.leftChildCondition = tc1;
        instance.rightChildCondition = tc2;
        boolean expResult = false;
        boolean result = instance.isMet();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class AndCondition.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TrueCondition tc1 = new TrueCondition();
        TrueCondition tc2 = new TrueCondition();
        XorCondition instance = new XorCondition();
        instance.leftChildCondition = tc1;
        instance.rightChildCondition = tc2;
        String expResult = "(" + tc1.toString() + " XOR " + tc2.toString() + ")";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormatString method, of class AndCondition.
     */
    @Test
    public void testGetFormatString() {
        System.out.println("getFormatString");
        XorCondition instance = new XorCondition();
        String expResult = "({leftChildCondition} XOR {rightChildCondition})";
        String result = instance.getFormatString();
        assertEquals(expResult, result);
    }
}
