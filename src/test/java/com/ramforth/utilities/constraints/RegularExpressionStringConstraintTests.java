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
public class RegularExpressionStringConstraintTests {
    
    public RegularExpressionStringConstraintTests() {
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
     * Test of isSatisfied method, of class RegularExpressionStringConstraint.
     */
    @Test
    public void isSatisfied_LowercaseCharactersAToZInConstructorAndLowercaseAToZInput_True() {
        System.out.println("isSatisfied");
        
        String input = "abcdefghijklmnopqrstuvwxyz";
        
        RegularExpressionStringConstraint lowercaseAToZ = new RegularExpressionStringConstraint("[a-z]+");
        boolean expectedResult = true;
        
        boolean result = lowercaseAToZ.isSatisfied(input);
        assertEquals(expectedResult, result);
    }
    
    /**
     * Test of isSatisfied method, of class RegularExpressionStringConstraint.
     */
    @Test
    public void isSatisfied_LowercaseCharactersAToZInConstructorAndEmptyInput_False() {
        System.out.println("isSatisfied");
        
        String input = "";
        
        RegularExpressionStringConstraint lowercaseAToZ = new RegularExpressionStringConstraint("[a-z]+");
        boolean expectedResult = false;
        
        boolean result = lowercaseAToZ.isSatisfied(input);
        assertEquals(expectedResult, result);
    }
}