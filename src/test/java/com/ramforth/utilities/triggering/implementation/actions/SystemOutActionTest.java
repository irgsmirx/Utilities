/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.actions;

import java.io.PrintStream;
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
public class SystemOutActionTest {
    
    public SystemOutActionTest() {
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
     * Test of getPrintStream method, of class SystemOutAction.
     */
    @Test
    public void testGetPrintStream() {
        System.out.println("getPrintStream");
        SystemOutAction instance = new SystemOutAction();
        PrintStream expResult = System.out;
        PrintStream result = instance.getPrintStream();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOutMessage method, of class SystemOutAction.
     */
    @Test
    public void testGetOutMessage() {
        System.out.println("getOutMessage");
        SystemOutAction instance = new SystemOutAction();
        String expResult = "aText";
        instance.setOutMessage(expResult);
        String result = instance.getOutMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOutMessage method, of class SystemOutAction.
     */
    @Test
    public void testSetOutMessage() {
        System.out.println("setOutMessage");
        String value = "aText";
        SystemOutAction instance = new SystemOutAction();
        instance.setOutMessage(value);
        assertEquals(value, instance.getOutMessage());
    }

    /**
     * Test of toString method, of class SystemOutAction.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SystemOutAction instance = new SystemOutAction();
        String expResult = "Schreibe \"\" nach System.out.";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
