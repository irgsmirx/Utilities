/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.inifile.implementation;

import com.ramforth.utilities.inifile.interfaces.IIniFile;
import com.ramforth.utilities.inifile.interfaces.IIniFileEntry;
import com.ramforth.utilities.inifile.interfaces.IIniFileSection;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

import static org.junit.Assert.*;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class IniFileWriterTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(IniFileWriterTest.class);

    public IniFileWriterTest() {
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
     * Test of write method, of class IniFileWriter.
     */
    @Test
    public void testWrite() {
        try {
            File f = File.createTempFile("Test", "Test");
            
            System.out.println("write");
            IIniFile iniFile = new IniFile();
            IIniFileSection testSection = new IniFileSection("Test");
            
            IIniFileEntry testEntry = new IniFileEntry("TestName", "TestValue");
            testSection.getEntries().add(testEntry);
            
            iniFile.getSections().add(testSection);
            IniFileWriter instance = new IniFileWriter(new FileOutputStream(f));
            instance.write(iniFile);
            
            
            IniFileReader iniFileReader = new IniFileReader();
            
            IIniFile iniFile2 = iniFileReader.parse(new FileInputStream(f));
            
            assertTrue(iniFile2.getSections().contains("Test"));            
        }
        catch (FileNotFoundException ex) {
            LOGGER.warn("Error", ex); //TODO Enter precise error message
        }
        catch (IOException ex) {
            LOGGER.warn("Error", ex); //TODO Enter precise error message
        }
        
    }

    /**
     * Test of setCloseStreamWhenDone method, of class IniFileWriter.
     */
    @Test
    public void testSetCloseStreamWhenDone() {
        System.out.println("setCloseStreamWhenDone");
        boolean value = false;
        IniFileWriter instance = new IniFileWriter(null);
        instance.setCloseStreamWhenDone(value);
        assertFalse(instance.isCloseStreamWhenDone());
    }

    /**
     * Test of isCloseStreamWhenDone method, of class IniFileWriter.
     */
    @Test
    public void testIsCloseStreamWhenDone() {
        System.out.println("isCloseStreamWhenDone");
        IniFileWriter instance = new IniFileWriter(null);
        instance.setCloseStreamWhenDone(false);
        boolean expResult = false;
        boolean result = instance.isCloseStreamWhenDone();
        assertEquals(expResult, result);
        
        
        instance.setCloseStreamWhenDone(true);
        expResult = true;
        result = instance.isCloseStreamWhenDone();
        assertEquals(expResult, result);
    }
}
