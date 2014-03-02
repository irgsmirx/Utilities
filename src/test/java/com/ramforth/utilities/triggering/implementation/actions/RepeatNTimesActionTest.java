/* 
 * Copyright (C) 2014 Tobias Ramforth
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
public class RepeatNTimesActionTest {
    
    public RepeatNTimesActionTest() {
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
        RepeatNTimesAction instance = new RepeatNTimesAction();
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
        RepeatNTimesAction instance = new RepeatNTimesAction();
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
        RepeatNTimesAction instance = new RepeatNTimesAction();
        instance.childAction = psa;
        instance.setN(5);
        instance.perform();
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
        RepeatNTimesAction instance = new RepeatNTimesAction();
        instance.childAction = na;
        instance.setN(3);
        String expResult = "Repeat 3 times: " + na.toString() + ".";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormatString method, of class RepeatNTimesAction.
     */
    @Test
    public void testGetFormatString() {
        System.out.println("getFormatString");
        RepeatNTimesAction instance = new RepeatNTimesAction();
        String expResult = "Repeat {n} times: {childAction}.";
        String result = instance.getFormatString();
        assertEquals(expResult, result);
    }
}
