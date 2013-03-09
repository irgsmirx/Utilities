/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
public class MaximumLengthStringConstraintTests {
    
    public MaximumLengthStringConstraintTests() {
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

    private boolean createMaximumStringLengthConstraintWithGivenLengthAndCallIsSatisfiedForInput(int length, String input) {
        return new MaximumLengthStringConstraint(length).isSatisfied(input);
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
        boolean result = createMaximumStringLengthConstraintWithGivenLengthAndCallIsSatisfiedForInput(length, input);

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
        boolean result = createMaximumStringLengthConstraintWithGivenLengthAndCallIsSatisfiedForInput(length, input);

        assertEquals(expectedResult, result);
    }
    
    /**
     * Test of isSatisfied method, of class ExactLengthStringConstraint.
     */
    @Test
    public void isSatisfied_OneInConstructorAndEmptyString_True() {
        System.out.println("isSatisfied");
        
        int length = 1;
        String input = "";
        
        boolean expectedResult = true;
        boolean result = createMaximumStringLengthConstraintWithGivenLengthAndCallIsSatisfiedForInput(length, input);

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
        boolean result = createMaximumStringLengthConstraintWithGivenLengthAndCallIsSatisfiedForInput(length, input);

        assertEquals(expectedResult, result);
    }
    
        /**
     * Test of isSatisfied method, of class ExactLengthStringConstraint.
     */
    @Test
    public void isSatisfied_OneInConstructorAndStringOfLengthTwo_False() {
        System.out.println("isSatisfied");
        
        int length = 1;
        String input = "aa";
        
        boolean expectedResult = false;
        boolean result = createMaximumStringLengthConstraintWithGivenLengthAndCallIsSatisfiedForInput(length, input);

        assertEquals(expectedResult, result);
    }
    
}