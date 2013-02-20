/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
public class AbstractPathConditionTest {
    
    public AbstractPathConditionTest() {
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
     * Test of getPath method, of class AbstractPathCondition.
     */
    @Test
    public void testGetPath() {
        System.out.println("getPath");
        AbstractPathCondition instance = new AbstractPathConditionImpl();
        String expResult = "aPath";
        instance.setPath(expResult);
        String result = instance.getPath();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPath method, of class AbstractPathCondition.
     */
    @Test
    public void testSetPath() {
        System.out.println("setPath");
        String value = "aPath";
        AbstractPathCondition instance = new AbstractPathConditionImpl();
        instance.setPath(value);
        assertEquals(value, instance.getPath());
    }

    public class AbstractPathConditionImpl extends AbstractPathCondition {

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
