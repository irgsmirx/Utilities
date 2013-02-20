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
