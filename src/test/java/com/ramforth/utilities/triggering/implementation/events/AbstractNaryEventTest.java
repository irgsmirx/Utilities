/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.events;

import java.util.ArrayList;
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
public class AbstractNaryEventTest {
    
    public AbstractNaryEventTest() {
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
     * Test of getChildEvents method, of class AbstractNaryEvent.
     */
    @Test
    public void testGetChildEvents() {
        System.out.println("getChildEvents");
        AbstractNaryEvent instance = new AbstractNaryEventImpl();
        AbstractEventImpl a = new AbstractEventImpl();
        AbstractEventImpl b = new AbstractEventImpl();
        AbstractEventImpl c = new AbstractEventImpl();
        AbstractEventImpl d = new AbstractEventImpl();
        instance.childEvents = new ArrayList<>();
        instance.childEvents.add(a);
        instance.childEvents.add(b);
        instance.childEvents.add(c);
        instance.childEvents.add(d);        
        Iterable result = instance.getChildEvents();
        Iterator iterator = result.iterator();
        assertEquals(a, iterator.next());
        assertEquals(b, iterator.next());
        assertEquals(c, iterator.next());
        assertEquals(d, iterator.next());
    }

    /**
     * Test of reset method, of class AbstractNaryEvent.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        AbstractNaryEvent instance = new AbstractNaryEventImpl();
        AbstractEventImpl a = new AbstractEventImpl();
        AbstractEventImpl b = new AbstractEventImpl();
        AbstractEventImpl c = new AbstractEventImpl();
        AbstractEventImpl d = new AbstractEventImpl();
        instance.childEvents = new ArrayList<>();
        instance.childEvents.add(a);
        instance.childEvents.add(b);
        instance.childEvents.add(c);
        instance.childEvents.add(d);
        instance.reset();
        assertTrue(a.resetted);
        assertTrue(b.resetted);
        assertTrue(c.resetted);
        assertTrue(d.resetted);
    }

    public class AbstractEventImpl extends AbstractEvent {

        public boolean resetted = false;
        
        @Override
        public boolean occurred() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void reset() {
            resetted = true;
        }

        @Override
        public String getFormatString() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    public class AbstractNaryEventImpl extends AbstractNaryEvent {

        @Override
        public boolean occurred() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public String getFormatString() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
