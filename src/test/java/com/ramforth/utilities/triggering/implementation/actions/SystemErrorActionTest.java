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
public class SystemErrorActionTest {
    
    public SystemErrorActionTest() {
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
     * Test of getPrintStream method, of class SystemErrorAction.
     */
    @Test
    public void testGetPrintStream() {
        System.out.println("getPrintStream");
        SystemErrorAction instance = new SystemErrorAction();
        PrintStream expResult = System.err;
        PrintStream result = instance.getPrintStream();
        assertEquals(expResult, result);
    }

    /**
     * Test of getErrorMessage method, of class SystemErrorAction.
     */
    @Test
    public void testGetErrorMessage() {
        System.out.println("getErrorMessage");
        SystemErrorAction instance = new SystemErrorAction();
        String expResult = "aText";
        instance.setErrorMessage(expResult);
        String result = instance.getErrorMessage();
        assertEquals(expResult, result);
    }

    /**
     * Test of setErrorMessage method, of class SystemErrorAction.
     */
    @Test
    public void testSetErrorMessage() {
        System.out.println("setErrorMessage");
        String value = "aText";
        SystemErrorAction instance = new SystemErrorAction();
        instance.setErrorMessage(value);
        assertEquals(value, instance.getErrorMessage());
    }

    /**
     * Test of toString method, of class SystemErrorAction.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SystemErrorAction instance = new SystemErrorAction();
        String expResult = "Schreibe \"\" nach System.err.";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
