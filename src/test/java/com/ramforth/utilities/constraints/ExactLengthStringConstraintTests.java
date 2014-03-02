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
package com.ramforth.utilities.constraints;

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
public class ExactLengthStringConstraintTests {
    
    public ExactLengthStringConstraintTests() {
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

    private boolean createExactStringLengthConstraintWithGivenLengthAndCallIsSatisfiedForInput(int length, String input) {
        return new ExactLengthStringConstraint(length).isSatisfied(input);
    }
    
    /**
     * Test of isSatisfied method, of class ExactLengthStringConstraint.
     */
    @Test
    public void isSatisfied_ZeroInConstructorAndEmptyString_True() {
        System.out.println("isSatisfied");
        
        int length = 0;
        String input = "";
        
        boolean expectedResult = true;
        boolean result = createExactStringLengthConstraintWithGivenLengthAndCallIsSatisfiedForInput(length, input);

        assertEquals(expectedResult, result);
    }
    
    /**
     * Test of isSatisfied method, of class ExactLengthStringConstraint.
     */
    @Test
    public void isSatisfied_ZeroInConstructorAndNonEmptyString_False() {
        System.out.println("isSatisfied");
        
        int length = 0;
        String input = "a";
        
        boolean expectedResult = false;
        boolean result = createExactStringLengthConstraintWithGivenLengthAndCallIsSatisfiedForInput(length, input);

        assertEquals(expectedResult, result);
    }
    
    /**
     * Test of isSatisfied method, of class ExactLengthStringConstraint.
     */
    @Test
    public void isSatisfied_OneInConstructorAndEmptyString_False() {
        System.out.println("isSatisfied");
        
        int length = 1;
        String input = "";
        
        boolean expectedResult = false;
        boolean result = createExactStringLengthConstraintWithGivenLengthAndCallIsSatisfiedForInput(length, input);

        assertEquals(expectedResult, result);
    }
    
    /**
     * Test of isSatisfied method, of class ExactLengthStringConstraint.
     */
    @Test
    public void isSatisfied_OneInConstructorAndStringOfLengthOne_True() {
        System.out.println("isSatisfied");
        
        int length = 1;
        String input = "a";
        
        boolean expectedResult = true;
        boolean result = createExactStringLengthConstraintWithGivenLengthAndCallIsSatisfiedForInput(length, input);

        assertEquals(expectedResult, result);
    }
    
}