/* 
 * Copyright (C) 2014 Tobias Ramforth
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ramforth.utilities.triggering.implementation;

import com.ramforth.utilities.triggering.interfaces.ITickable;
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
public class TimerTest {
    
    public TimerTest() {
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
     * Test of start method, of class Timer.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        Timer instance = new Timer();
        instance.start();
        assertTrue(instance.isRunning());
    }

    /**
     * Test of stop method, of class Timer.
     */
    @Test
    public void testStop() {
        System.out.println("stop");
        Timer instance = new Timer();
        instance.stop();
        assertFalse(instance.isRunning());
    }

    /**
     * Test of isRunning method, of class Timer.
     */
    @Test
    public void testIsRunningWhenNotRunning() {
        System.out.println("isRunning (not running)");
        Timer instance = new Timer();
        boolean expResult = false;
        boolean result = instance.isRunning();
        assertEquals(expResult, result);
    }

    /**
     * Test of isRunning method, of class Timer.
     */
    @Test
    public void testIsRunningWhenRunning() {
        System.out.println("isRunning (running)");
        Timer instance = new Timer();
        boolean expResult = true;
        instance.start();
        boolean result = instance.isRunning();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of addTickable method, of class Timer.
     */
    @Test
    public void testAddTickable() {
        System.out.println("addTickable");
        ITickable value = new Tickable();
        Timer instance = new Timer();
        instance.addTickable(value);
        assertEquals(value, instance.iterator().next());
    }

    /**
     * Test of removeTickable method, of class Timer.
     */
    @Test
    public void testRemoveTickable() {
        System.out.println("removeTickable");
        ITickable value = new Tickable();
        Timer instance = new Timer();
        instance.addTickable(value);
        instance.removeTickable(value);
        assertFalse(instance.iterator().hasNext());
    }

    /**
     * Test of removeTickableAt method, of class Timer.
     */
    @Test
    public void testRemoveTickableAt() {
        System.out.println("removeTickableAt");
        int index = 0;
        Timer instance = new Timer();
        ITickable value = new Tickable();
        instance.addTickable(value);
        instance.removeTickableAt(index);
        assertFalse(instance.iterator().hasNext());
    }

    /**
     * Test of numberOfTickables method, of class Timer.
     */
    @Test
    public void testNumberOfTickablesIfEmpty() {
        System.out.println("numberOfTickables (empty)");
        Timer instance = new Timer();
        int expResult = 0;
        int result = instance.numberOfTickables();
        assertEquals(expResult, result);
    }

    /**
     * Test of numberOfTickables method, of class Timer.
     */
    @Test
    public void testNumberOfTickablesIfNotEmpty() {
        System.out.println("numberOfTickables (not emopty)");
        Timer instance = new Timer();
        int expResult = 1;
        instance.addTickable(new Tickable());
        int result = instance.numberOfTickables();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of iterator method, of class Timer.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        Timer instance = new Timer();
        
        ITickable a = new Tickable();
        ITickable b = new Tickable();
        ITickable c = new Tickable();

        instance.addTickable(a);
        instance.addTickable(b);
        instance.addTickable(c);
        
        Iterator result = instance.iterator();
        assertEquals(a, result.next());
        assertEquals(b, result.next());
        assertEquals(c, result.next());
    }

    /**
     * Test of tick method, of class Timer.
     */
    @Test
    public void testTick() {
        System.out.println("tick");
        long time = 0L;
        Timer instance = new Timer();
        Tickable tickable = new Tickable();
        instance.addTickable(tickable);
        instance.tick(time);
        assertTrue(tickable.ticked);
    }

    /**
     * Test of getInterval method, of class Timer.
     */
    @Test
    public void testGetInterval() {
        System.out.println("getInterval");
        Timer instance = new Timer();
        long expResult = 321L;
        instance.setInterval(expResult);
        long result = instance.getInterval();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInterval method, of class Timer.
     */
    @Test
    public void testSetInterval() {
        System.out.println("setInterval");
        long value = 123L;
        Timer instance = new Timer();
        instance.setInterval(value);
        assertEquals(value, instance.getInterval());
    }
    
    public class Tickable extends AbstractTickable {

        public boolean ticked = false;
        
        @Override
        public boolean tick() {
            this.ticked = true;
            return false;
        }
        
    }
}
