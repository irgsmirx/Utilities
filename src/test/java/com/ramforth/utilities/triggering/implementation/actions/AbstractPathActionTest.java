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
public class AbstractPathActionTest {
    
    public AbstractPathActionTest() {
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
     * Test of getPath method, of class AbstractPathAction.
     */
    @Test
    public void testGetPath() {
        System.out.println("getPath");
        AbstractPathAction instance = new AbstractPathActionImpl();
        String expResult = "/just/some/path";
        instance.setPath(expResult);
        String result = instance.getPath();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPath method, of class AbstractPathAction.
     */
    @Test
    public void testSetPath() {
        System.out.println("setPath");
        String value = "/some/other/path";
        AbstractPathAction instance = new AbstractPathActionImpl();
        instance.setPath(value);
        assertEquals(value, instance.getPath());
    }

    public class AbstractPathActionImpl extends AbstractPathAction {

        @Override
        public void perform() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public String getFormatString() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
