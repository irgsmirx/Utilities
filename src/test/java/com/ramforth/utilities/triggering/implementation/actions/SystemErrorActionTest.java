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
