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
public class AndConditionTest {
    
    public AndConditionTest() {
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
    public void testTrueAndFalseIsMet() {
        System.out.println("isMet (true & false)");
        TrueCondition tc = new TrueCondition();
        FalseCondition fc = new FalseCondition();
        AndCondition instance = new AndCondition();
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
    public void testFalseAndFalseIsMet() {
        System.out.println("isMet (false & false)");
        FalseCondition fc1 = new FalseCondition();
        FalseCondition fc2 = new FalseCondition();
        AndCondition instance = new AndCondition();
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
    public void testTrueAndTrueIsMet() {
        System.out.println("isMet (true & true)");
        TrueCondition tc1 = new TrueCondition();
        TrueCondition tc2 = new TrueCondition();
        AndCondition instance = new AndCondition();
        instance.leftChildCondition = tc1;
        instance.rightChildCondition = tc2;
        boolean expResult = true;
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
        AndCondition instance = new AndCondition();
        instance.leftChildCondition = tc1;
        instance.rightChildCondition = tc2;
        String expResult = "(" + tc1.toString() + " AND " + tc2.toString() + ")";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormatString method, of class AndCondition.
     */
    @Test
    public void testGetFormatString() {
        System.out.println("getFormatString");
        AndCondition instance = new AndCondition();
        String expResult = "({leftChildCondition} AND {rightChildCondition})";
        String result = instance.getFormatString();
        assertEquals(expResult, result);
    }
}
