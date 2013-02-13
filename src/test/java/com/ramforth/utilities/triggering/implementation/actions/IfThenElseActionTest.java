/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.actions;

import com.ramforth.utilities.triggering.implementation.conditions.AbstractCondition;
import com.ramforth.utilities.triggering.interfaces.IAction;
import com.ramforth.utilities.triggering.interfaces.ICondition;
import java.util.Iterator;
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
public class IfThenElseActionTest {
    
    public IfThenElseActionTest() {
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
     * Test of getIfConditions method, of class IfThenElseAction.
     */
    @Test
    public void testGetIfConditions() {
        System.out.println("getIfConditions");
        IfThenElseAction instance = new IfThenElseAction();
        
        ICondition a = new AbstractConditionImpl(true);
        ICondition b = new AbstractConditionImpl(true);
        ICondition c = new AbstractConditionImpl(true);
        
        instance.addCondition(a);
        instance.addCondition(b);
        instance.addCondition(c);
        
        Iterable result = instance.getIfConditions();
        Iterator iterator = result.iterator();
        
        assertEquals(a, iterator.next());
        assertEquals(b, iterator.next());
        assertEquals(c, iterator.next());
    }

    /**
     * Test of clearConditions method, of class IfThenElseAction.
     */
    @Test
    public void testClearConditions() {
        System.out.println("clearConditions");
        IfThenElseAction instance = new IfThenElseAction();
        instance.addCondition(new AbstractConditionImpl(true));
        instance.addCondition(new AbstractConditionImpl(true));
        instance.clearConditions();

        assertFalse(instance.getIfConditions().iterator().hasNext());
    }

    /**
     * Test of addCondition method, of class IfThenElseAction.
     */
    @Test
    public void testAddCondition() {
        System.out.println("addCondition");
        ICondition c = new AbstractConditionImpl(true);
        IfThenElseAction instance = new IfThenElseAction();
        instance.addCondition(c);
        
        assertEquals(c, instance.getIfConditions().iterator().next());
    }

    /**
     * Test of removeCondition method, of class IfThenElseAction.
     */
    @Test
    public void testRemoveCondition() {
        System.out.println("removeCondition");
        ICondition c = new AbstractConditionImpl(true);
        IfThenElseAction instance = new IfThenElseAction();
        instance.addCondition(c);
        
        instance.removeCondition(c);

        assertFalse(instance.getIfConditions().iterator().hasNext());
    }

    /**
     * Test of removeConditionAt method, of class IfThenElseAction.
     */
    @Test
    public void testRemoveConditionAt() {
        System.out.println("removeConditionAt");
        int index = 0;
        IfThenElseAction instance = new IfThenElseAction();
        instance.addCondition(new AbstractConditionImpl(true));
        
        instance.removeConditionAt(index);
        
        assertFalse(instance.getIfConditions().iterator().hasNext());
    }

    /**
     * Test of getThenActions method, of class IfThenElseAction.
     */
    @Test
    public void testGetThenActions() {
        System.out.println("getThenActions");
        IfThenElseAction instance = new IfThenElseAction();

        IAction a = new AbstractActionImpl();
        IAction b = new AbstractActionImpl();
        IAction c = new AbstractActionImpl();
        
        instance.addThenAction(a);
        instance.addThenAction(b);
        instance.addThenAction(c);
        
        Iterable result = instance.getThenActions();
        Iterator iterator = result.iterator();
        
        assertEquals(a, iterator.next());
        assertEquals(b, iterator.next());
        assertEquals(c, iterator.next());
    }

    /**
     * Test of clearThenActions method, of class IfThenElseAction.
     */
    @Test
    public void testClearThenActions() {
        System.out.println("clearThenActions");
        IfThenElseAction instance = new IfThenElseAction();
        instance.addThenAction(new AbstractActionImpl());
        instance.addThenAction(new AbstractActionImpl());
        instance.clearThenActions();

        assertFalse(instance.getThenActions().iterator().hasNext());
    }

    /**
     * Test of addThenAction method, of class IfThenElseAction.
     */
    @Test
    public void testAddThenAction() {
        System.out.println("addThenAction");
        IAction a = null;
        IfThenElseAction instance = new IfThenElseAction();
        instance.addThenAction(a);
        
        assertEquals(a, instance.getThenActions().iterator().next());
    }

    /**
     * Test of removeThenAction method, of class IfThenElseAction.
     */
    @Test
    public void testRemoveThenAction() {
        System.out.println("removeThenAction");
        IAction a = new AbstractActionImpl();
        IfThenElseAction instance = new IfThenElseAction();
        instance.addThenAction(a);

        instance.removeThenAction(a);

        assertFalse(instance.getThenActions().iterator().hasNext());
    }

    /**
     * Test of removeThenActionAt method, of class IfThenElseAction.
     */
    @Test
    public void testRemoveThenActionAt() {
        System.out.println("removeThenActionAt");
        int index = 0;
        IfThenElseAction instance = new IfThenElseAction();
        instance.addThenAction(new AbstractActionImpl());
        
        instance.removeThenActionAt(index);
        
        assertFalse(instance.getThenActions().iterator().hasNext());
    }

    /**
     * Test of getElseActions method, of class IfThenElseAction.
     */
    @Test
    public void testGetElseActions() {
        System.out.println("getElseActions");
        IfThenElseAction instance = new IfThenElseAction();

        IAction a = new AbstractActionImpl();
        IAction b = new AbstractActionImpl();
        IAction c = new AbstractActionImpl();
        
        instance.addElseAction(a);
        instance.addElseAction(b);
        instance.addElseAction(c);
        
        Iterable result = instance.getElseActions();
        Iterator iterator = result.iterator();
        
        assertEquals(a, iterator.next());
        assertEquals(b, iterator.next());
        assertEquals(c, iterator.next());
    }

    /**
     * Test of clearElseActions method, of class IfThenElseAction.
     */
    @Test
    public void testClearElseActions() {
        System.out.println("clearElseActions");
        IfThenElseAction instance = new IfThenElseAction();
        instance.addElseAction(new AbstractActionImpl());
        instance.addElseAction(new AbstractActionImpl());
        instance.clearElseActions();

        assertFalse(instance.getElseActions().iterator().hasNext());
    }

    /**
     * Test of addElseAction method, of class IfThenElseAction.
     */
    @Test
    public void testAddElseAction() {
        System.out.println("addElseAction");
        IAction a = new AbstractActionImpl();
        IfThenElseAction instance = new IfThenElseAction();
        instance.addElseAction(a);
        
        assertEquals(a, instance.getElseActions().iterator().next());
    }

    /**
     * Test of removeElseAction method, of class IfThenElseAction.
     */
    @Test
    public void testRemoveElseAction() {
        System.out.println("removeElseAction");
        IAction a = new AbstractActionImpl();
        IfThenElseAction instance = new IfThenElseAction();

        instance.addElseAction(a);

        instance.removeElseAction(a);

        assertFalse(instance.getElseActions().iterator().hasNext());
    }

    /**
     * Test of removeElseActionAt method, of class IfThenElseAction.
     */
    @Test
    public void testRemoveElseActionAt() {
        System.out.println("removeElseActionAt");
        int index = 0;
        IfThenElseAction instance = new IfThenElseAction();
        
        instance.addElseAction(new AbstractActionImpl());
        
        instance.removeElseActionAt(index);
        
        assertFalse(instance.getElseActions().iterator().hasNext());
    }

    /**
     * Test of perform method, of class IfThenElseAction.
     */
    @Test
    public void testPerformIfConditionIsMet() {
        System.out.println("perform (condition is met)");
        IfThenElseAction instance = new IfThenElseAction();
        
        instance.addCondition(new AbstractConditionImpl(true));
        instance.addThenAction(new AbstractActionImpl());
        instance.addElseAction(new AbstractActionImpl());
        
        instance.perform();
        
        assertTrue(((AbstractActionImpl)instance.getThenActions().iterator().next()).performed);
        assertFalse(((AbstractActionImpl)instance.getElseActions().iterator().next()).performed);
    }

    /**
     * Test of perform method, of class IfThenElseAction.
     */
    @Test
    public void testPerformIfConditionIsNotMet() {
        System.out.println("perform (condition is not met)");
        IfThenElseAction instance = new IfThenElseAction();
        
        instance.addCondition(new AbstractConditionImpl(false));
        instance.addThenAction(new AbstractActionImpl());
        instance.addElseAction(new AbstractActionImpl());
        
        instance.perform();
        
        assertFalse(((AbstractActionImpl)instance.getThenActions().iterator().next()).performed);
        assertTrue(((AbstractActionImpl)instance.getElseActions().iterator().next()).performed);
    }
    
    
    /**
     * Test of getFormatString method, of class IfThenElseAction.
     */
    @Test
    public void testGetFormatString() {
        System.out.println("getFormatString");
        IfThenElseAction instance = new IfThenElseAction();
        String expResult = "IF {ifConditions} THEN {thenActions} ELSE {elseActions}";
        String result = instance.getFormatString();
        assertEquals(expResult, result);
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
