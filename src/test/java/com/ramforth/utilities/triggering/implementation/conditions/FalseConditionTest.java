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
