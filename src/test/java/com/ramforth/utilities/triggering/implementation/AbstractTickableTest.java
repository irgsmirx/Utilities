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
package com.ramforth.utilities.triggering.implementation;

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
public class AbstractTickableTest {
    
    public AbstractTickableTest() {
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
     * Test of tick method, of class AbstractTickable.
     */
    @Test
    public void testTick() {
        System.out.println("tick");
        long milliseconds = 123L;
        AbstractTickableImpl instance = new AbstractTickableImpl();
        boolean expResult = true;
        boolean result = instance.tick(milliseconds);
        assertEquals(expResult, instance.ticked);
        assertEquals(milliseconds, instance.lastTickedMilliseconds);
    }

    public class AbstractTickableImpl extends AbstractTickable {

        public boolean ticked = false;
        
        @Override
        public boolean tick() {
            this.ticked = true;
            return ticked;
        }
        
    }
}
