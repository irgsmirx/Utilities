/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.templates;

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
		OutputStream outputStream = null;
		StringTemplate instance = null;
		instance.renderTo(outputStream);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
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
}
