/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.expressions.writers.implementation;

import com.ramforth.utilities.expressions.interfaces.IAddExpression;
import com.ramforth.utilities.expressions.interfaces.IAndExpression;
import com.ramforth.utilities.expressions.interfaces.IBinaryExpression;
import com.ramforth.utilities.expressions.interfaces.IConditionalExpression;
import com.ramforth.utilities.expressions.interfaces.IConstantExpression;
import com.ramforth.utilities.expressions.interfaces.IDivideExpression;
import com.ramforth.utilities.expressions.interfaces.IEqualExpression;
import com.ramforth.utilities.expressions.interfaces.IExpression;
import com.ramforth.utilities.expressions.interfaces.IGreaterOrEqualExpression;
import com.ramforth.utilities.expressions.interfaces.IGreaterThanExpression;
import com.ramforth.utilities.expressions.interfaces.ILessOrEqualExpression;
import com.ramforth.utilities.expressions.interfaces.ILessThanExpression;
import com.ramforth.utilities.expressions.interfaces.IModuloExpression;
import com.ramforth.utilities.expressions.interfaces.IMultiplyExpression;
import com.ramforth.utilities.expressions.interfaces.INegateExpression;
import com.ramforth.utilities.expressions.interfaces.INorExpression;
import com.ramforth.utilities.expressions.interfaces.INotEqualExpression;
import com.ramforth.utilities.expressions.interfaces.IOrExpression;
import com.ramforth.utilities.expressions.interfaces.IParameterExpression;
import com.ramforth.utilities.expressions.interfaces.IParenthesizedExpression;
import com.ramforth.utilities.expressions.interfaces.IPowerExpression;
import com.ramforth.utilities.expressions.interfaces.IPropertyExpression;
import com.ramforth.utilities.expressions.interfaces.ISubtractExpression;
import com.ramforth.utilities.expressions.interfaces.IUnaryExpression;
import com.ramforth.utilities.expressions.interfaces.IXorExpression;
import com.ramforth.utilities.expressions.writers.interfaces.IExpressionWriter;
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
public class ExpressionWriterTest {

    protected IExpressionWriter expressionWriter;
    
    public ExpressionWriterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        expressionWriter = new ExpressionWriter();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IAddExpression() {
        System.out.println("write");
        IAddExpression expression = null;
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IAndExpression() {
        System.out.println("write");
        IAndExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IBinaryExpression() {
        System.out.println("write");
        IBinaryExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IConditionalExpression() {
        System.out.println("write");
        IConditionalExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IDivideExpression() {
        System.out.println("write");
        IDivideExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IEqualExpression() {
        System.out.println("write");
        IEqualExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IExpression() {
        System.out.println("write");
        IExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IGreaterOrEqualExpression() {
        System.out.println("write");
        IGreaterOrEqualExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IGreaterThanExpression() {
        System.out.println("write");
        IGreaterThanExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_ILessOrEqualExpression() {
        System.out.println("write");
        ILessOrEqualExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_ILessThanExpression() {
        System.out.println("write");
        ILessThanExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IModuloExpression() {
        System.out.println("write");
        IModuloExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IMultiplyExpression() {
        System.out.println("write");
        IMultiplyExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_INegateExpression() {
        System.out.println("write");
        INegateExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_INorExpression() {
        System.out.println("write");
        INorExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_INotEqualExpression() {
        System.out.println("write");
        INotEqualExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IOrExpression() {
        System.out.println("write");
        IOrExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IParameterExpression() {
        System.out.println("write");
        IParameterExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IParenthesizedExpression() {
        System.out.println("write");
        IParenthesizedExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IPowerExpression() {
        System.out.println("write");
        IPowerExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IPropertyExpression() {
        System.out.println("write");
        IPropertyExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_ISubtractExpression() {
        System.out.println("write");
        ISubtractExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IUnaryExpression() {
        System.out.println("write");
        IUnaryExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IXorExpression() {
        System.out.println("write");
        IXorExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IConstantExpression() {
        System.out.println("write");
        IConstantExpression expression = null;
        
        expressionWriter.write(expression);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}