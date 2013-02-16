/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation;

import com.ramforth.utilities.triggering.interfaces.ITrigger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author tobias
 */
public class AbstractTriggerChildTest {
    
    public AbstractTriggerChildTest() {
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
     * Test of getParent method, of class AbstractTriggerChild.
     */
    @Test
    public void testGetParent() {
        System.out.println("getParent");
        ITrigger expResult = new Trigger();
        AbstractTriggerChild instance = new AbstractTriggerChildImplParent(expResult);
        ITrigger result = instance.getParent();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormatString method, of class AbstractTriggerChild.
     */
    @Test
    public void testGetFormatString() {
        System.out.println("getFormatString");
        String expResult = "FormatString";
        AbstractTriggerChild instance = new AbstractTriggerChildImpl(expResult);
        String result = instance.getFormatString();
        assertEquals(expResult, result);
    }

    public class AbstractTriggerChildImplParent extends AbstractTriggerChild {

        public AbstractTriggerChildImplParent(ITrigger parent) {
            this.parent = parent;
        }
        
        @Override
        public String getFormatString() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    public class AbstractTriggerChildImpl extends AbstractTriggerChild {

        private String formatString;
        
        public AbstractTriggerChildImpl(String formatString) {
            this.formatString = formatString;
        }
        
        @Override
        public String getFormatString() {
            return formatString;
        }
    }
}
