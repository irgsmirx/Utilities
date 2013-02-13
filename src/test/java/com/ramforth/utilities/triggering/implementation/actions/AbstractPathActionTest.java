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
