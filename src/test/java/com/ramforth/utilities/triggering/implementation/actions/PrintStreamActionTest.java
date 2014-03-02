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
package com.ramforth.utilities.triggering.implementation.actions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
public class PrintStreamActionTest {
    
    public PrintStreamActionTest() {
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
     * Test of getTextWriter method, of class TextWriterAction.
     */
    @Test
    public void testGetTextWriter() {
        System.out.println("getTextWriter");
        PrintStreamAction instance = new PrintStreamAction();
        PrintStream expResult = System.out;
        instance.setPrintStream(expResult);
        PrintStream result = instance.getPrintStream();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTextWriter method, of class TextWriterAction.
     */
    @Test
    public void testSetTextWriter() {
        System.out.println("setTextWriter");
        PrintStream value = System.out;
        PrintStreamAction instance = new PrintStreamAction();
        instance.setPrintStream(value);
        assertEquals(value, instance.getPrintStream());
    }

    /**
     * Test of getText method, of class TextWriterAction.
     */
    @Test
    public void testGetText() {
        System.out.println("getText");
        PrintStreamAction instance = new PrintStreamAction();
        String expResult = "aText";
        instance.setText(expResult);
        String result = instance.getText();
        assertEquals(expResult, result);
    }

    /**
     * Test of setText method, of class TextWriterAction.
     */
    @Test
    public void testSetText() {
        System.out.println("setText");
        String value = "aText";
        PrintStreamAction instance = new PrintStreamAction();
        instance.setText(value);
        assertEquals(value, instance.getText());
    }

    /**
     * Test of perform method, of class TextWriterAction.
     */
    @Test
    public void testPerform() {
        System.out.println("perform");
        PrintStreamAction instance = new PrintStreamAction();
        String aText = "aText" + System.lineSeparator();
        instance.setText(aText);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        instance.setPrintStream(ps);
        instance.perform();
        assertEquals(aText, baos.toString());
    }

    /**
     * Test of toString method, of class TextWriterAction.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PrintStreamAction instance = new PrintStreamAction();
        String expResult = "Schreibe den Text \"\" als Zeile in den PrintStream \"null\".";
        System.err.println(expResult);
        System.err.println(instance.toString());
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormatString method, of class TextWriterAction.
     */
    @Test
    public void testGetFormatString() {
        System.out.println("getFormatString");
        PrintStreamAction instance = new PrintStreamAction();
        String expResult = "Schreibe den Text {text} als Zeile in den PrintStream {textWriter}.";
        String result = instance.getFormatString();
        assertEquals(expResult, result);
    }
}
