/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
