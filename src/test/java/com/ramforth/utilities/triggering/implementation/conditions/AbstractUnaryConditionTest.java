/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
