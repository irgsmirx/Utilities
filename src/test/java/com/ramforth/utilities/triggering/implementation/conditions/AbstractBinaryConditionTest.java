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

import com.ramforth.utilities.triggering.interfaces.ICondition;
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
public class AbstractBinaryConditionTest {
    
    public AbstractBinaryConditionTest() {
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
     * Test of getLeftChildCondition method, of class AbstractBinaryCondition.
     */
    @Test
    public void testGetLeftChildCondition() {
        System.out.println("getLeftChildCondition");
        AbstractBinaryCondition instance = new AbstractBinaryConditionImpl();
        ICondition expResult = new TrueCondition();
        instance.setLeftChildCondition(expResult);
        ICondition result = instance.getLeftChildCondition();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLeftChildCondition method, of class AbstractBinaryCondition.
     */
    @Test
    public void testSetLeftChildCondition() {
        System.out.println("setLeftChildCondition");
        ICondition value = new TrueCondition();
        AbstractBinaryCondition instance = new AbstractBinaryConditionImpl();
        instance.setLeftChildCondition(value);
        assertEquals(value, instance.getLeftChildCondition());
    }

    /**
     * Test of getRightChildCondition method, of class AbstractBinaryCondition.
     */
    @Test
    public void testGetRightChildCondition() {
        System.out.println("getRightChildCondition");
        AbstractBinaryCondition instance = new AbstractBinaryConditionImpl();
        ICondition expResult = new TrueCondition();
        instance.setRightChildCondition(expResult);
        ICondition result = instance.getRightChildCondition();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRightChildCondition method, of class AbstractBinaryCondition.
     */
    @Test
    public void testSetRightChildCondition() {
        System.out.println("setRightChildCondition");
        ICondition value = new TrueCondition();
        AbstractBinaryCondition instance = new AbstractBinaryConditionImpl();
        instance.setRightChildCondition(value);
        assertEquals(value, instance.getRightChildCondition());
    }

    public class AbstractBinaryConditionImpl extends AbstractBinaryCondition {
        
        @Override
        public boolean isMet() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public String getFormatString() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
