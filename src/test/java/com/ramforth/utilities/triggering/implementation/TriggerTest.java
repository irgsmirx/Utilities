/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation;

import com.ramforth.utilities.triggering.implementation.actions.AbstractAction;
import com.ramforth.utilities.triggering.implementation.actions.IfThenElseActionTest;
import com.ramforth.utilities.triggering.implementation.conditions.AbstractCondition;
import com.ramforth.utilities.triggering.implementation.events.AbstractEvent;
import com.ramforth.utilities.triggering.implementation.variables.AbstractVariable;
import com.ramforth.utilities.triggering.interfaces.IAction;
import com.ramforth.utilities.triggering.interfaces.ICondition;
import com.ramforth.utilities.triggering.interfaces.IEvent;
import com.ramforth.utilities.triggering.interfaces.IVariable;
import java.util.Iterator;
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
        
        instance.addAction(new AbstractActionImpl());
        instance.addCondition(new AbstractConditionImpl(true));
        instance.addEvent(new AbstractEventImpl(true));
        instance.addVariable(new AbstractVariableImpl());
        
        instance.clear();
        
        assertFalse(instance.getActions().iterator().hasNext());
        assertFalse(instance.getConditions().iterator().hasNext());
        assertFalse(instance.getEvents().iterator().hasNext());
        assertFalse(instance.getVariables().iterator().hasNext());
    }

    /**
     * Test of evaluate method, of class Trigger.
     */
    @Test
    public void testEvaluatePerformed() {
        System.out.println("evaluate performed");
        Trigger instance = new Trigger();
        
        AbstractActionImpl action = new AbstractActionImpl();
        
        instance.addEvent(new AbstractEventImpl(true));
        instance.addCondition(new AbstractConditionImpl(true));
        instance.addAction(action);
        
        instance.evaluate();
        
        assertTrue(action.performed);
    }

    /**
     * Test of evaluate method, of class Trigger.
     */
    @Test
    public void testEvaluatePerformedMultipleEvents() {
        System.out.println("evaluate performed");
        Trigger instance = new Trigger();
        
        AbstractActionImpl action = new AbstractActionImpl();
        
        instance.addEvent(new AbstractEventImpl(true));
        instance.addEvent(new AbstractEventImpl(false));
        instance.addEvent(new AbstractEventImpl(true));
        instance.addEvent(new AbstractEventImpl(false));
        instance.addCondition(new AbstractConditionImpl(true));
        instance.addAction(action);
        
        instance.evaluate();
        
        assertTrue(action.performed);
    }

    /**
     * Test of evaluate method, of class Trigger.
     */
    @Test
    public void testEvaluatePerformedMultipleConditions() {
        System.out.println("evaluate performed");
        Trigger instance = new Trigger();
        
        AbstractActionImpl action = new AbstractActionImpl();
        
        instance.addEvent(new AbstractEventImpl(true));
        instance.addCondition(new AbstractConditionImpl(true));
        instance.addCondition(new AbstractConditionImpl(true));
        instance.addCondition(new AbstractConditionImpl(true));
        instance.addCondition(new AbstractConditionImpl(true));
        instance.addAction(action);
        
        instance.evaluate();
        
        assertTrue(action.performed);
    }
    
    
    /**
     * Test of evaluate method, of class Trigger.
     */
    @Test
    public void testEvaluateNotPerformed() {
        System.out.println("evaluate not performed");
        Trigger instance = new Trigger();
        
        AbstractActionImpl action = new AbstractActionImpl();
        
        instance.addEvent(new AbstractEventImpl(false));
        instance.addCondition(new AbstractConditionImpl(true));
        instance.addAction(action);
        
        instance.evaluate();
        
        assertFalse(action.performed);
    }
    
    /**
     * Test of evaluate method, of class Trigger.
     */
    @Test
    public void testEvaluateNotPerformedMultipleEvents() {
        System.out.println("evaluate not performed");
        Trigger instance = new Trigger();
        
        AbstractActionImpl action = new AbstractActionImpl();
        
        instance.addEvent(new AbstractEventImpl(false));
        instance.addEvent(new AbstractEventImpl(false));
        instance.addEvent(new AbstractEventImpl(false));
        instance.addEvent(new AbstractEventImpl(false));
        instance.addCondition(new AbstractConditionImpl(true));
        instance.addAction(action);
        
        instance.evaluate();
        
        assertFalse(action.performed);
    }    
    
    /**
     * Test of evaluate method, of class Trigger.
     */
    @Test
    public void testEvaluateNotPerformedMultipleConditions() {
        System.out.println("evaluate not performed");
        Trigger instance = new Trigger();
        
        AbstractActionImpl action = new AbstractActionImpl();
        
        instance.addEvent(new AbstractEventImpl(true));
        instance.addCondition(new AbstractConditionImpl(false));
        instance.addAction(action);
        
        instance.evaluate();
        
        assertFalse(action.performed);
    }     
    
    
    /**
     * Test of getEvents method, of class Trigger.
     */
    @Test
    public void testGetEvents() {
        System.out.println("getEvents");
        Trigger instance = new Trigger();
        AbstractEventImpl a = new AbstractEventImpl(true);
        AbstractEventImpl b = new AbstractEventImpl(true);
        AbstractEventImpl c = new AbstractEventImpl(true);

        instance.addEvent(a);
        instance.addEvent(b);
        instance.addEvent(c);
        
        Iterable result = instance.getEvents();
        Iterator iterator = result.iterator();
        
        assertEquals(a, iterator.next());
        assertEquals(b, iterator.next());
        assertEquals(c, iterator.next()); 
    }

    /**
     * Test of clearEvents method, of class Trigger.
     */
    @Test
    public void testClearEvents() {
        System.out.println("clearEvents");
        Trigger instance = new Trigger();
        
        instance.addEvent(new AbstractEventImpl(true));
        
        instance.clearEvents();
        
        assertFalse(instance.getEvents().iterator().hasNext());
    }

    /**
     * Test of addEvent method, of class Trigger.
     */
    @Test
    public void testAddEvent() {
        System.out.println("addEvent");
        IEvent value = new AbstractEventImpl(true);
        Trigger instance = new Trigger();
        instance.addEvent(value);
        assertEquals(value, instance.getEvents().iterator().next());
    }

    /**
     * Test of removeEvent method, of class Trigger.
     */
    @Test
    public void testRemoveEvent() {
        System.out.println("removeEvent");
        IEvent value = new AbstractEventImpl(true);
        Trigger instance = new Trigger();
        instance.addEvent(value);
        instance.removeEvent(value);
        assertFalse(instance.getEvents().iterator().hasNext());
    }

    /**
     * Test of removeEventAt method, of class Trigger.
     */
    @Test
    public void testRemoveEventAt() {
        System.out.println("removeEventAt");
        int index = 0;
        Trigger instance = new Trigger();
        instance.addEvent(new AbstractEventImpl(true));
        instance.removeEventAt(index);
        assertFalse(instance.getEvents().iterator().hasNext());
    }

    /**
     * Test of getVariables method, of class Trigger.
     */
    @Test
    public void testGetVariables() {
        System.out.println("getVariables");
        Trigger instance = new Trigger();
        
        AbstractVariableImpl a = new AbstractVariableImpl();
        AbstractVariableImpl b = new AbstractVariableImpl();
        AbstractVariableImpl c = new AbstractVariableImpl();

        instance.addVariable(a);
        instance.addVariable(b);
        instance.addVariable(c);
        
        Iterable result = instance.getVariables();
        Iterator iterator = result.iterator();
        
        assertEquals(a, iterator.next());
        assertEquals(b, iterator.next());
        assertEquals(c, iterator.next());
    }

    /**
     * Test of clearVariables method, of class Trigger.
     */
    @Test
    public void testClearVariables() {
        System.out.println("clearVariables");
        Trigger instance = new Trigger();
        
        instance.addVariable(new AbstractVariableImpl());
        
        instance.clearVariables();
        
        assertFalse(instance.getVariables().iterator().hasNext());
    }

    /**
     * Test of addVariable method, of class Trigger.
     */
    @Test
    public void testAddVariable() {
        System.out.println("addVariable");
        IVariable value = new AbstractVariableImpl();
        Trigger instance = new Trigger();
        instance.addVariable(value);
        assertEquals(value, instance.getVariables().iterator().next());
    }

    /**
     * Test of removeVariable method, of class Trigger.
     */
    @Test
    public void testRemoveVariable() {
        System.out.println("removeVariable");
        IVariable value = new AbstractVariableImpl();
        Trigger instance = new Trigger();
        instance.addVariable(value);
        instance.removeVariable(value);
        assertFalse(instance.getVariables().iterator().hasNext());
    }

    /**
     * Test of removeVariableAt method, of class Trigger.
     */
    @Test
    public void testRemoveVariableAt() {
        System.out.println("removeVariableAt");
        int index = 0;
        Trigger instance = new Trigger();
        instance.addVariable(new AbstractVariableImpl());
        instance.removeVariableAt(index);
        assertFalse(instance.getVariables().iterator().hasNext());
    }

    /**
     * Test of getConditions method, of class Trigger.
     */
    @Test
    public void testGetConditions() {
        System.out.println("getConditions");
        Trigger instance = new Trigger();
    
        AbstractConditionImpl a = new AbstractConditionImpl(true);
        AbstractConditionImpl b = new AbstractConditionImpl(true);
        AbstractConditionImpl c = new AbstractConditionImpl(true);

        instance.addCondition(a);
        instance.addCondition(b);
        instance.addCondition(c);
        
        Iterable result = instance.getConditions();
        Iterator iterator = result.iterator();
        
        assertEquals(a, iterator.next());
        assertEquals(b, iterator.next());
        assertEquals(c, iterator.next());    
    }

    /**
     * Test of clearConditions method, of class Trigger.
     */
    @Test
    public void testClearConditions() {
        System.out.println("clearConditions");
        Trigger instance = new Trigger();
        
        instance.addCondition(new AbstractConditionImpl(true));
                
        instance.clearConditions();
        
        assertFalse(instance.getConditions().iterator().hasNext());
    }

    /**
     * Test of addCondition method, of class Trigger.
     */
    @Test
    public void testAddCondition() {
        System.out.println("addCondition");
        ICondition value = new AbstractConditionImpl(true);
        Trigger instance = new Trigger();
        instance.addCondition(value);
        assertEquals(value, instance.getConditions().iterator().next());
    }

    /**
     * Test of removeCondition method, of class Trigger.
     */
    @Test
    public void testRemoveCondition() {
        System.out.println("removeCondition");
        ICondition value = new AbstractConditionImpl(true);
        Trigger instance = new Trigger();
        instance.addCondition(value);
        instance.removeCondition(value);
        assertFalse(instance.getConditions().iterator().hasNext());
    }

    /**
     * Test of removeConditionAt method, of class Trigger.
     */
    @Test
    public void testRemoveConditionAt() {
        System.out.println("removeConditionAt");
        int index = 0;
        Trigger instance = new Trigger();
        instance.addCondition(new AbstractConditionImpl(true));
        instance.removeConditionAt(index);
        assertFalse(instance.getConditions().iterator().hasNext());
    }

    /**
     * Test of getActions method, of class Trigger.
     */
    @Test
    public void testGetActions() {
        System.out.println("getActions");
        Trigger instance = new Trigger();
        AbstractActionImpl a = new AbstractActionImpl();
        AbstractActionImpl b = new AbstractActionImpl();
        AbstractActionImpl c = new AbstractActionImpl();

        instance.addAction(a);
        instance.addAction(b);
        instance.addAction(c);
        
        Iterable result = instance.getActions();
        Iterator iterator = result.iterator();
        
        assertEquals(a, iterator.next());
        assertEquals(b, iterator.next());
        assertEquals(c, iterator.next()); 
    }

    /**
     * Test of clearActions method, of class Trigger.
     */
    @Test
    public void testClearActions() {
        System.out.println("clearActions");
        Trigger instance = new Trigger();
        
        instance.addAction(new AbstractActionImpl());
        
        instance.clearActions();

        assertFalse(instance.getActions().iterator().hasNext());
    }

    /**
     * Test of addAction method, of class Trigger.
     */
    @Test
    public void testAddAction() {
        System.out.println("addAction");
        IAction value = new AbstractActionImpl();
        Trigger instance = new Trigger();
        instance.addAction(value);
        assertEquals(value, instance.getActions().iterator().next());
    }

    /**
     * Test of removeAction method, of class Trigger.
     */
    @Test
    public void testRemoveAction() {
        System.out.println("removeAction");
        IAction value = new AbstractActionImpl();
        Trigger instance = new Trigger();
        instance.addAction(value);
        instance.removeAction(value);
        assertFalse(instance.getActions().iterator().hasNext());
    }

    /**
     * Test of removeActionAt method, of class Trigger.
     */
    @Test
    public void testRemoveActionAt() {
        System.out.println("removeActionAt");
        int index = 0;
        Trigger instance = new Trigger();
        instance.addAction(new AbstractActionImpl());
        instance.removeActionAt(index);
        assertFalse(instance.getActions().iterator().hasNext());
    }

    /**
     * Test of toString method, of class Trigger.
     */
    @Test
    public void testToStringNoName() {
        System.out.println("toString");
        Trigger instance = new Trigger();
        String expResult = "?TRIGGER?";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Trigger.
     */
    @Test
    public void testToStringWithName() {
        System.out.println("toString");
        Trigger instance = new Trigger("MyTrigger");
        String expResult = "MyTrigger";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    
    public class AbstractActionImpl extends AbstractAction {

        public boolean performed = false;
        
        @Override
        public void perform() {
            this.performed = true;
        }

        @Override
        public String getFormatString() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    public class AbstractEventImpl extends AbstractEvent {

        private boolean occurred;
        
        public AbstractEventImpl(boolean occurred) {
            this.occurred = occurred;
        }
        
        @Override
        public boolean occurred() {
            return occurred;
        }

        @Override
        public void reset() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public String getFormatString() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    public class AbstractVariableImpl extends AbstractVariable {

        @Override
        public String getFormatString() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    public class AbstractConditionImpl extends AbstractCondition {

        private boolean met;
        
        public AbstractConditionImpl(boolean met) {
            this.met = met;
        }
        
        @Override
        public boolean isMet() {
            return met;
        }

        @Override
        public String getFormatString() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
}
