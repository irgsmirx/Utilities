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
public class NorConditionTest {
    
    public NorConditionTest() {
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
     * Test of isMet method, of class AndCondition.
     */
    @Test
    public void testTrueNorFalseIsMet() {
        System.out.println("isMet (true NOR false)");
        TrueCondition tc = new TrueCondition();
        FalseCondition fc = new FalseCondition();
        NorCondition instance = new NorCondition();
        instance.leftChildCondition = tc;
        instance.rightChildCondition = fc;
        boolean expResult = false;
        boolean result = instance.isMet();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isMet method, of class AndCondition.
     */
    @Test
    public void testFalseNorFalseIsMet() {
        System.out.println("isMet (false NOR false)");
        FalseCondition fc1 = new FalseCondition();
        FalseCondition fc2 = new FalseCondition();
        NorCondition instance = new NorCondition();
        instance.leftChildCondition = fc1;
        instance.rightChildCondition = fc2;
        boolean expResult = true;
        boolean result = instance.isMet();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isMet method, of class AndCondition.
     */
    @Test
    public void testTrueNorTrueIsMet() {
        System.out.println("isMet (true NOR true)");
        TrueCondition tc1 = new TrueCondition();
        TrueCondition tc2 = new TrueCondition();
        NorCondition instance = new NorCondition();
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
        NorCondition instance = new NorCondition();
        instance.leftChildCondition = tc1;
        instance.rightChildCondition = tc2;
        String expResult = "(NEITHER " + tc1.toString() + " NOR " + tc2.toString() + ")";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormatString method, of class AndCondition.
     */
    @Test
    public void testGetFormatString() {
        System.out.println("getFormatString");
        NorCondition instance = new NorCondition();
        String expResult = "(NEITHER {leftChildCondition} NOR {rightChildCondition})";
        String result = instance.getFormatString();
        assertEquals(expResult, result);
    }
}
