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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FileExistsConditionTest {
    
    public FileExistsConditionTest() {
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
     * Test of isMet method, of class FileExistsCondition.
     */
    @Test
    public void testExistingFileIsMet() {
        System.out.println("isMet (exists)");
        Path tempFile = null;
        try {
            tempFile = Files.createTempFile("test", "txt");
            FileExistsCondition instance = new FileExistsCondition();
            instance.path = tempFile.toString();
            boolean expResult = true;
            boolean result = instance.isMet();
            assertEquals(expResult, result);
            Files.delete(tempFile);
        }
        catch (IOException ex) {
            fail(ex.getMessage());
        }
    }

    /**
     * Test of isMet method, of class FileExistsCondition.
     */
    @Test
    public void testNonExistingFileIsMet() {
        System.out.println("isMet (does not exist)");
        Path tempFile = Paths.get("yölkxjfhgkyjlxdfhgkljyslghylkgj.txt");
        FileExistsCondition instance = new FileExistsCondition();
        instance.path = tempFile.toString();
        boolean expResult = false;
        boolean result = instance.isMet();
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of toString method, of class FileExistsCondition.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FileExistsCondition instance = new FileExistsCondition();
        String path = "blabla.txt";
        instance.path = path;
        String expResult = "Die Datei \"" + path + "\" existiert";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFormatString method, of class FileExistsCondition.
     */
    @Test
    public void testGetFormatString() {
        System.out.println("getFormatString");
        FileExistsCondition instance = new FileExistsCondition();
        String expResult = "Die Datei {path} existiert";
        String result = instance.getFormatString();
        assertEquals(expResult, result);
    }
}
