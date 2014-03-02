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
package com.ramforth.utilities.triggering.implementation.conditions;

import com.ramforth.utilities.triggering.interfaces.ICondition;
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
public class AbstractNaryConditionTest {
    
    public AbstractNaryConditionTest() {
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
     * Test of getChildConditions method, of class AbstractNaryCondition.
     */
    @Test
    public void testGetChildConditions() {
        System.out.println("getChildConditions");
        AbstractNaryCondition instance = new AbstractNaryConditionImpl();
        instance.childConditions = new ArrayList<>();
        TrueCondition a = new TrueCondition();
        FalseCondition b = new FalseCondition();
        TrueCondition c = new TrueCondition();
        FalseCondition d = new FalseCondition();
        instance.childConditions.add(a);
        instance.childConditions.add(b);
        instance.childConditions.add(c);
        instance.childConditions.add(d);
        Iterable result = instance.getChildConditions();
        Iterator iterator = result.iterator();
        assertEquals(a, iterator.next());
        assertEquals(b, iterator.next());
        assertEquals(c, iterator.next());
        assertEquals(d, iterator.next());
    }

    public class AbstractNaryConditionImpl extends AbstractNaryCondition {

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
