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

import com.ramforth.utilities.triggering.interfaces.IAction;
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
public class AbstractUnaryActionTest {
    
    public AbstractUnaryActionTest() {
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
     * Test of getChildAction method, of class AbstractUnaryAction.
     */
    @Test
    public void testGetChildAction() {
        System.out.println("getChildAction");
        AbstractUnaryAction instance = new AbstractUnaryActionImpl();
        IAction expResult = new AbstractUnaryActionImpl();
        instance.setchildAction(expResult);
        IAction result = instance.getChildAction();
        assertEquals(expResult, result);
    }

    /**
     * Test of setchildAction method, of class AbstractUnaryAction.
     */
    @Test
    public void testSetchildAction() {
        System.out.println("setchildAction");
        IAction value = new AbstractUnaryActionImpl();
        AbstractUnaryAction instance = new AbstractUnaryActionImpl();
        instance.setchildAction(value);
        assertEquals(value, instance.getChildAction());
    }

    @Test
    public void testPerform() {
        System.out.println("perform");
        AbstractActionImpl value = new AbstractActionImpl();
        AbstractUnaryAction instance = new AbstractUnaryActionImpl();
        instance.setchildAction(value);
        instance.perform();
        assertTrue(value.performed);
    }
    
    
    public class AbstractActionImpl extends AbstractAction {

        public boolean performed = false;
        
        @Override
        public void perform() {
            performed = true;
        }

        @Override
        public String getFormatString() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    public class AbstractUnaryActionImpl extends AbstractUnaryAction {

        @Override
        public void perform() {
            childAction.perform();
        }

        @Override
        public String getFormatString() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
