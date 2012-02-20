/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fractions.implementation;

import fractions.interfaces.IFraction;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author Administrator
 */
public class SimpleFractionTest {
    
    public SimpleFractionTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNumerator method, of class SimpleFraction.
     */
    @Test
    public void testGetNumerator() {
        System.out.println("getNumerator");
        SimpleFraction instance = new SimpleFraction(1, 2);
        int expResult = 1;
        int result = instance.getNumerator();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumerator method, of class SimpleFraction.
     */
    @Test
    public void testSetNumerator() {
        System.out.println("setNumerator");
        int value = 5;
        SimpleFraction instance = new SimpleFraction(1, 2);
        instance.setNumerator(value);
        assertEquals(instance.numerator, 5);
    }

    /**
     * Test of getDenominator method, of class SimpleFraction.
     */
    @Test
    public void testGetDenominator() {
        System.out.println("getDenominator");
        SimpleFraction instance = new SimpleFraction(2, 4);
        int expResult = 4;
        int result = instance.getDenominator();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDenominator method, of class SimpleFraction.
     */
    @Test
    public void testSetDenominator() {
        System.out.println("setDenominator");
        int value = 7;
        SimpleFraction instance = new SimpleFraction(3, 8);
        instance.setDenominator(value);
        assertEquals(instance.getDenominator(), 7);
    }

    /**
     * Test of isProper method, of class SimpleFraction.
     */
    @Test
    public void testIsProper() {
        System.out.println("isProper");
        SimpleFraction instance = new SimpleFraction(300, 70);
        boolean expResult = false;
        boolean result = instance.isProper();
        assertEquals(expResult, result);
    }

    /**
     * Test of isImproper method, of class SimpleFraction.
     */
    @Test
    public void testIsImproper() {
        System.out.println("isImproper");
        SimpleFraction instance = new SimpleFraction(70, 400);
        boolean expResult = false;
        boolean result = instance.isImproper();
        assertEquals(expResult, result);
    }

    /**
     * Test of reciprocal method, of class SimpleFraction.
     */
    @Test
    public void testReciprocal() {
        System.out.println("reciprocal");
        SimpleFraction instance = new SimpleFraction(10, 20);
        IFraction expResult = new SimpleFraction(20, 10);
        IFraction result = instance.reciprocal();
        assertEquals(expResult, result);
    }

    /**
     * Test of reduce method, of class SimpleFraction.
     */
    @Test
    public void testReduce() {
        System.out.println("reduce");
        SimpleFraction instance = new SimpleFraction(5, 10);
        IFraction expResult = new SimpleFraction(1, 2);
        IFraction result = instance.reduce();
        assertEquals(expResult, result);
    }

    /**
     * Test of floatValue method, of class SimpleFraction.
     */
    @Test
    public void testFloatValue() {
        System.out.println("floatValue");
        SimpleFraction instance = new SimpleFraction(23, 60);
        float expResult = 23.0f / 60.0f;
        float result = instance.floatValue();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of doubleValue method, of class SimpleFraction.
     */
    @Test
    public void testDoubleValue() {
        System.out.println("doubleValue");
        SimpleFraction instance = new SimpleFraction(47, 80);
        double expResult = 47.0d / 80.0d;
        double result = instance.doubleValue();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of toString method, of class SimpleFraction.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SimpleFraction instance = new SimpleFraction(2, 3);
        String expResult = "2/3";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

        /**
     * Test of toString method, of class SimpleFraction.
     */
    @Test
    public void testToMixedString() {
        System.out.println("toMixedString");
        SimpleFraction instance = new SimpleFraction(7, 3);
        String expResult = "2 1/3";
        String result = instance.toMixedString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of add method, of class SimpleFraction.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        IFraction value = new SimpleFraction(1, 10);
        SimpleFraction instance = new SimpleFraction(1, 5);
        IFraction expResult = new SimpleFraction(3, 10);
        IFraction result = instance.add(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of subtract method, of class SimpleFraction.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        IFraction value = new SimpleFraction(5, 10);
        SimpleFraction instance = new SimpleFraction(13, 20);
        IFraction expResult = new SimpleFraction(3, 20);
        IFraction result = instance.subtract(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of multiply method, of class SimpleFraction.
     */
    @Test
    public void testMultiply_IFraction() {
        System.out.println("multiply");
        IFraction value = new SimpleFraction(1, 2);
        SimpleFraction instance = new SimpleFraction(2, 3);
        IFraction expResult = new SimpleFraction(2, 6);
        IFraction result = instance.multiply(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of multiply method, of class SimpleFraction.
     */
    @Test
    public void testMultiply_int() {
        System.out.println("multiply");
        int value = 3;
        SimpleFraction instance = new SimpleFraction(5, 6);
        IFraction expResult = new SimpleFraction(15, 6);
        IFraction result = instance.multiply(value);
        assertEquals(expResult, result);
    }
}
