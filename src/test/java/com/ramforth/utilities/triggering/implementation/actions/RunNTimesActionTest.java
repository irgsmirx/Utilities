/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.actions;

import java.io.ByteArrayOutputStream;
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
public class RunNTimesActionTest {
    
    public RunNTimesActionTest() {
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
     * Test of getN method, of class RepeatNTimesAction.
     */
    @Test
    public void testGetN() {
        System.out.println("getN");
        RunNTimesAction instance = new RunNTimesAction();
        int expResult = 7;
        instance.setN(expResult);
        int result = instance.getN();
        assertEquals(expResult, result);
    }

    /**
     * Test of setN method, of class RepeatNTimesAction.
     */
    @Test
    public void testSetN() {
        System.out.println("setN");
        int value = 9;
        RunNTimesAction instance = new RunNTimesAction();
        instance.setN(value);
        assertEquals(value, instance.getN());
    }

    /**
     * Test of perform method, of class RepeatNTimesAction.
     */
    @Test
    public void testPerform() {
        System.out.println("perform");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStreamAction psa = new PrintStreamAction();
        psa.setPrintStream(new PrintStream(baos));
        psa.setText("Test");
        RunNTimesAction instance = new RunNTimesAction();
        instance.childAction = psa;
        int n = 5;
        instance.setN(n);
        for (int i = 0; i < (n * 2); i++) {
            instance.perform();
        }
        String expResult = "TestTestTestTestTest";

        assertEquals(expResult, baos.toString());
    }

    /**
     * Test of toString method, of class RepeatNTimesAction.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        NullAction na = new NullAction();
        RunNTimesAction instance = new RunNTimesAction();
        instance.childAction = na;
        instance.setN(3);
        String expResult = "Run 3 times: " + na.toString() + ".";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormatString method, of class RepeatNTimesAction.
     */
    @Test
    public void testGetFormatString() {
        System.out.println("getFormatString");
        RunNTimesAction instance = new RunNTimesAction();
        String expResult = "Run {n} times: {childAction}.";
        String result = instance.getFormatString();
        assertEquals(expResult, result);
    }
}
