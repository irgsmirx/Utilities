/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.expressions.writers.implementation;

import com.ramforth.utilities.expressions.implementation.AddExpression;
import com.ramforth.utilities.expressions.implementation.AndExpression;
import com.ramforth.utilities.expressions.implementation.ConstantExpression;
import com.ramforth.utilities.expressions.implementation.DivideExpression;
import com.ramforth.utilities.expressions.implementation.EqualExpression;
import com.ramforth.utilities.expressions.implementation.GreaterOrEqualExpression;
import com.ramforth.utilities.expressions.implementation.GreaterThanExpression;
import com.ramforth.utilities.expressions.implementation.LessOrEqualExpression;
import com.ramforth.utilities.expressions.implementation.LessThanExpression;
import com.ramforth.utilities.expressions.implementation.ModuloExpression;
import com.ramforth.utilities.expressions.implementation.MultiplyExpression;
import com.ramforth.utilities.expressions.implementation.NegateExpression;
import com.ramforth.utilities.expressions.implementation.NorExpression;
import com.ramforth.utilities.expressions.implementation.NotEqualExpression;
import com.ramforth.utilities.expressions.implementation.NotExpression;
import com.ramforth.utilities.expressions.implementation.OrExpression;
import com.ramforth.utilities.expressions.implementation.ParenthesizedExpression;
import com.ramforth.utilities.expressions.implementation.PowerExpression;
import com.ramforth.utilities.expressions.implementation.PropertyExpression;
import com.ramforth.utilities.expressions.implementation.SubtractExpression;
import com.ramforth.utilities.expressions.implementation.XorExpression;
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
import com.ramforth.utilities.expressions.interfaces.INotExpression;
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
    protected IConstantExpression constantExpressionA;
    protected IConstantExpression constantExpressionB;
    
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
        constantExpressionA = new ConstantExpression(12);
        constantExpressionB = new ConstantExpression(23);
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
        IAddExpression expression = new AddExpression(constantExpressionA, constantExpressionB);
        expressionWriter.write(expression);
        String expected = constantExpressionA.getValue().toString() + " + " + constantExpressionB.getValue().toString();
        assertEquals(expected, expressionWriter.toString());
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IAndExpression() {
        System.out.println("write");
        IAndExpression expression = new AndExpression(new ConstantExpression(true), new ConstantExpression(false));
        expressionWriter.write(expression);
        String expected = "(true AND false)";
        assertEquals(expected, expressionWriter.toString());
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
        IDivideExpression expression = new DivideExpression(constantExpressionA, constantExpressionB);
        expressionWriter.write(expression);
        String expected = constantExpressionA.getValue().toString() + " / " + constantExpressionB.getValue().toString();
        assertEquals(expected, expressionWriter.toString());
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IEqualExpression() {
        System.out.println("write");
        IEqualExpression expression = new EqualExpression(constantExpressionA, constantExpressionB);
        expressionWriter.write(expression);
        String expected = constantExpressionA.getValue().toString() + " = " + constantExpressionB.getValue().toString();
        assertEquals(expected, expressionWriter.toString());
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
        IGreaterOrEqualExpression expression = new GreaterOrEqualExpression(constantExpressionA, constantExpressionB);
        expressionWriter.write(expression);
        String expected = constantExpressionA.getValue().toString() + " >= " + constantExpressionB.getValue().toString();
        assertEquals(expected, expressionWriter.toString());
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IGreaterThanExpression() {
        System.out.println("write");
        IGreaterThanExpression expression = new GreaterThanExpression(constantExpressionA, constantExpressionB);
        expressionWriter.write(expression);
        String expected = constantExpressionA.getValue().toString() + " > " + constantExpressionB.getValue().toString();
        assertEquals(expected, expressionWriter.toString());
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_ILessOrEqualExpression() {
        System.out.println("write");
        ILessOrEqualExpression expression = new LessOrEqualExpression(constantExpressionA, constantExpressionB);
        expressionWriter.write(expression);
        String expected = constantExpressionA.getValue().toString() + " <= " + constantExpressionB.getValue().toString();
        assertEquals(expected, expressionWriter.toString());
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_ILessThanExpression() {
        System.out.println("write");
        ILessThanExpression expression = new LessThanExpression(constantExpressionA, constantExpressionB);
        expressionWriter.write(expression);
        String expected = constantExpressionA.getValue().toString() + " < " + constantExpressionB.getValue().toString();
        assertEquals(expected, expressionWriter.toString());
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IModuloExpression() {
        System.out.println("write");
        IModuloExpression expression = new ModuloExpression(constantExpressionA, constantExpressionB);
        expressionWriter.write(expression);
        String expected = constantExpressionA.getValue().toString() + " % " + constantExpressionB.getValue().toString();
        assertEquals(expected, expressionWriter.toString());
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IMultiplyExpression() {
        System.out.println("write");
        IMultiplyExpression expression = new MultiplyExpression(constantExpressionA, constantExpressionB);
        expressionWriter.write(expression);
        String expected = constantExpressionA.getValue().toString() + " * " + constantExpressionB.getValue().toString();
        assertEquals(expected, expressionWriter.toString());
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_INegateExpression() {
        System.out.println("write");
        INegateExpression expression = new NegateExpression(constantExpressionA);
        expressionWriter.write(expression);
        String expected = "(-" + constantExpressionA.getValue().toString() + ")";
        assertEquals(expected, expressionWriter.toString());
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_INorExpression() {
        System.out.println("write");
        INorExpression expression = new NorExpression(new ConstantExpression(true), new ConstantExpression(false));
        expressionWriter.write(expression);
        String expected = "(true NOR false)";
        assertEquals(expected, expressionWriter.toString());
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_INotEqualExpression() {
        System.out.println("write");
        INotEqualExpression expression = new NotEqualExpression(constantExpressionA, constantExpressionB);
        expressionWriter.write(expression);
        String expected = constantExpressionA.getValue().toString() + " != " + constantExpressionB.getValue().toString();
        assertEquals(expected, expressionWriter.toString());
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_INotExpression() {
        System.out.println("write");
        INotExpression expression = new NotExpression(new ConstantExpression(true));
        expressionWriter.write(expression);
        String expected = "NOT(true)";
        assertEquals(expected, expressionWriter.toString());
    }    
    
    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IOrExpression() {
        System.out.println("write");
        IOrExpression expression = new OrExpression(new ConstantExpression(true), new ConstantExpression(false));
        expressionWriter.write(expression);
        String expected = "(true OR false)";
        assertEquals(expected, expressionWriter.toString());
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
        IParenthesizedExpression expression = new ParenthesizedExpression(constantExpressionA);
        String expected = "(" + constantExpressionA.getValue().toString() + ")";
        expressionWriter.write(expression);
        assertEquals(expected, expressionWriter.toString());
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IPowerExpression() {
        System.out.println("write");
        IPowerExpression expression = new PowerExpression(constantExpressionA, constantExpressionB);
        String expected = constantExpressionA.getValue().toString() + "^" + constantExpressionB.getValue().toString();
        expressionWriter.write(expression);
        assertEquals(expected, expressionWriter.toString());
    }

    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IPropertyExpression() {
        System.out.println("write");
        IPropertyExpression expression = new PropertyExpression(constantExpressionA, "propertyName");
        
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
        ISubtractExpression expression = new SubtractExpression(constantExpressionA, constantExpressionB);
        String expected = constantExpressionA.getValue().toString() + " - " + constantExpressionB.getValue().toString();
        expressionWriter.write(expression);
        assertEquals(expected, expressionWriter.toString());
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
        IXorExpression expression = new XorExpression(new ConstantExpression(true), new ConstantExpression(false));
        expressionWriter.write(expression);
        String expected = "(true XOR false)";
        assertEquals(expected, expressionWriter.toString());
    }
    
    /**
     * Test of write method, of class ExpressionWriter.
     */
    @Test
    public void testWrite_IConstantExpression() {
        System.out.println("write");
        expressionWriter.write(constantExpressionA);
        assertEquals(constantExpressionA.getValue().toString(), expressionWriter.toString());
    }
}