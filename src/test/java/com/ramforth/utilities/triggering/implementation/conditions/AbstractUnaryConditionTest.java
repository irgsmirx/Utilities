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
public class AbstractUnaryConditionTest {
    
    public AbstractUnaryConditionTest() {
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
     * Test of getChildCondition method, of class AbstractUnaryCondition.
     */
    @Test
    public void testGetChildCondition() {
        System.out.println("getChildCondition");
        AbstractUnaryCondition instance = new AbstractUnaryConditionImpl();
        ICondition expResult = new TrueCondition();
        instance.setChildCondition(expResult);
        ICondition result = instance.getChildCondition();
        assertEquals(expResult, result);
    }

    /**
     * Test of setChildCondition method, of class AbstractUnaryCondition.
     */
    @Test
    public void testSetChildCondition() {
        System.out.println("setChildCondition");
        ICondition value = new TrueCondition();
        AbstractUnaryCondition instance = new AbstractUnaryConditionImpl();
        instance.setChildCondition(value);
        assertEquals(value, instance.getChildCondition());
    }

    public class AbstractUnaryConditionImpl extends AbstractUnaryCondition {

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
