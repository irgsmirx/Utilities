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
package com.ramforth.utilities.templates;

import java.io.OutputStream;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author tobias
 */
public class StringTemplateTest {

    public StringTemplateTest() {
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
     * Test of renderTo method, of class StringTemplate.
     */
    @Test
    public void testRenderTo() {
        System.out.println("renderTo");
        OutputStream outputStream = System.out;
        String templateString = "Dies ist ein {test}.";
        StringTemplate instance = new StringTemplate(templateString);
        instance.add("test", "ganz toller Test");
        instance.renderTo(outputStream);
    }

    /**
     * Test of render method, of class StringTemplate.
     */
    @Test
    public void testRender() {
        System.out.println("render");
        String templateString = "Dies ist ein {test}.";
        StringTemplate instance = new StringTemplate(templateString);
        instance.add("test", "Test");
        String expResult = "Dies ist ein Test.";
        String result = instance.render();
        assertEquals(expResult, result);
    }

    @Test
    public void testRenderComplex() {
        System.out.println("renderComplex");
        String templateString = "Dies ist ein {test}.";
        StringTemplate instance = new StringTemplate(templateString);

        String subTemplateString = "wirklich ganz toller {test}";
        StringTemplate subTemplate = new StringTemplate(subTemplateString);
        subTemplate.add("test", "TEST");
        instance.add("test", subTemplate);

        String expResult = "Dies ist ein wirklich ganz toller TEST.";
        String result = instance.render();
        assertEquals(expResult, result);
    }

    @Test
    public void testRenderArray() {
        System.out.println("renderArray");
        String templateString = "Dies ist ein {test[0]}.";
        StringTemplate instance = new StringTemplate(templateString);

        instance.add("test", new String[]{ "Test" });

        String expResult = "Dies ist ein Test.";
        String result = instance.render();
        assertEquals(expResult, result);
    }

    @Test
    public void testSpecialCharacter() {
        System.out.println("render");
        String templateString = "Dies ist ein {test}.";
        StringTemplate instance = new StringTemplate(templateString);
        instance.add("test", "Test");
        String expResult = "Dies ist ein Test.";
        String result = instance.render();
        assertEquals(expResult, result);
    }
}
