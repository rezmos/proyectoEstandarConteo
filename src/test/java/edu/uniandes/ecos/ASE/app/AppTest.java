/**
 * Unit test for simple App.
 *
 * Fecha de creacion: Febrero 14 de 2016
 *
 * @Version 1.0
 * @Author Claudia Marcela Alvarez Ramos item : 2, totalSize: total:30, Items:2
 */
package edu.uniandes.ecos.ASE.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AppTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * #Method
     *
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * #Method
     *
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }
}
