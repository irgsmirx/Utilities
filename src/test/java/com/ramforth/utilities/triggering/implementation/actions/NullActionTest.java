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
public class NullActionTest {
    
    public NullActionTest() {
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
     * Test of perform method, of class NullAction.
     */
    @Test
    public void testPerform() {
        System.out.println("perform");
        NullAction instance = new NullAction();
        instance.perform();
        assertTrue(true);
    }

    /**
     * Test of toString method, of class NullAction.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        NullAction instance = new NullAction();
        String expResult = "Nichts";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormatString method, of class NullAction.
     */
    @Test
    public void testGetFormatString() {
        System.out.println("getFormatString");
        NullAction instance = new NullAction();
        String expResult = "Nichts";
        String result = instance.getFormatString();
        assertEquals(expResult, result);
    }
}
