/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
public class AbstractActionTest {
    
    public AbstractActionTest() {
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
     * Test of perform method, of class AbstractAction.
     */
    @Test
    public void testPerform() {
        System.out.println("perform");
        AbstractActionImpl instance = new AbstractActionImpl();
        instance.perform();
        assertTrue(instance.performed);
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
}
