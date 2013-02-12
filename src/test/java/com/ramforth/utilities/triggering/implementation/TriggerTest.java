/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation;

import com.ramforth.utilities.triggering.interfaces.IAction;
import com.ramforth.utilities.triggering.interfaces.ICondition;
import com.ramforth.utilities.triggering.interfaces.IEvent;
import com.ramforth.utilities.triggering.interfaces.IVariable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tobias
 */
public class TriggerTest {
    
    public TriggerTest() {
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
     * Test of getName method, of class Trigger.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Trigger instance = new Trigger();
        String expResult = "aName";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Trigger.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String value = "aName";
        Trigger instance = new Trigger();
        instance.setName(value);
        assertEquals(value, instance.getName());
    }

    /**
     * Test of clear method, of class Trigger.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Trigger instance = new Trigger();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of evaluate method, of class Trigger.
     */
    @Test
    public void testEvaluate() {
        System.out.println("evaluate");
        Trigger instance = new Trigger();
        instance.evaluate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEvents method, of class Trigger.
     */
    @Test
    public void testGetEvents() {
        System.out.println("getEvents");
        Trigger instance = new Trigger();
        Iterable expResult = null;
        Iterable result = instance.getEvents();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearEvents method, of class Trigger.
     */
    @Test
    public void testClearEvents() {
        System.out.println("clearEvents");
        Trigger instance = new Trigger();
        instance.clearEvents();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEvent method, of class Trigger.
     */
    @Test
    public void testAddEvent() {
        System.out.println("addEvent");
        IEvent value = null;
        Trigger instance = new Trigger();
        instance.addEvent(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeEvent method, of class Trigger.
     */
    @Test
    public void testRemoveEvent() {
        System.out.println("removeEvent");
        IEvent value = null;
        Trigger instance = new Trigger();
        instance.removeEvent(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeEventAt method, of class Trigger.
     */
    @Test
    public void testRemoveEventAt() {
        System.out.println("removeEventAt");
        int index = 0;
        Trigger instance = new Trigger();
        instance.removeEventAt(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVariables method, of class Trigger.
     */
    @Test
    public void testGetVariables() {
        System.out.println("getVariables");
        Trigger instance = new Trigger();
        Iterable expResult = null;
        Iterable result = instance.getVariables();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearVariables method, of class Trigger.
     */
    @Test
    public void testClearVariables() {
        System.out.println("clearVariables");
        Trigger instance = new Trigger();
        instance.clearVariables();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addVariable method, of class Trigger.
     */
    @Test
    public void testAddVariable() {
        System.out.println("addVariable");
        IVariable value = null;
        Trigger instance = new Trigger();
        instance.addVariable(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeVariable method, of class Trigger.
     */
    @Test
    public void testRemoveVariable() {
        System.out.println("removeVariable");
        IVariable value = null;
        Trigger instance = new Trigger();
        instance.removeVariable(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeVariableAt method, of class Trigger.
     */
    @Test
    public void testRemoveVariableAt() {
        System.out.println("removeVariableAt");
        int index = 0;
        Trigger instance = new Trigger();
        instance.removeVariableAt(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConditions method, of class Trigger.
     */
    @Test
    public void testGetConditions() {
        System.out.println("getConditions");
        Trigger instance = new Trigger();
        Iterable expResult = null;
        Iterable result = instance.getConditions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearConditions method, of class Trigger.
     */
    @Test
    public void testClearConditions() {
        System.out.println("clearConditions");
        Trigger instance = new Trigger();
        instance.clearConditions();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCondition method, of class Trigger.
     */
    @Test
    public void testAddCondition() {
        System.out.println("addCondition");
        ICondition value = null;
        Trigger instance = new Trigger();
        instance.addCondition(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCondition method, of class Trigger.
     */
    @Test
    public void testRemoveCondition() {
        System.out.println("removeCondition");
        ICondition value = null;
        Trigger instance = new Trigger();
        instance.removeCondition(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeConditionAt method, of class Trigger.
     */
    @Test
    public void testRemoveConditionAt() {
        System.out.println("removeConditionAt");
        int index = 0;
        Trigger instance = new Trigger();
        instance.removeConditionAt(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActions method, of class Trigger.
     */
    @Test
    public void testGetActions() {
        System.out.println("getActions");
        Trigger instance = new Trigger();
        Iterable expResult = null;
        Iterable result = instance.getActions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearActions method, of class Trigger.
     */
    @Test
    public void testClearActions() {
        System.out.println("clearActions");
        Trigger instance = new Trigger();
        instance.clearActions();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAction method, of class Trigger.
     */
    @Test
    public void testAddAction() {
        System.out.println("addAction");
        IAction value = null;
        Trigger instance = new Trigger();
        instance.addAction(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAction method, of class Trigger.
     */
    @Test
    public void testRemoveAction() {
        System.out.println("removeAction");
        IAction value = null;
        Trigger instance = new Trigger();
        instance.removeAction(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeActionAt method, of class Trigger.
     */
    @Test
    public void testRemoveActionAt() {
        System.out.println("removeActionAt");
        int index = 0;
        Trigger instance = new Trigger();
        instance.removeActionAt(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Trigger.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Trigger instance = new Trigger();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
