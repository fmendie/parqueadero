/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package parqueaderos;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author pipe7
 */
public class AutomovilNGTest {
    
    public AutomovilNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

  @Test
    public void testAutomovil() {
    Automovil auto = new Automovil("ABC123", "Toyota", "Corolla", "Gasolina");
    
    assertEquals(auto.getPlaca(), "ABC123");
    assertEquals(auto.getMarca(), "Toyota");
    assertEquals(auto.getModelo(), "Corolla");
}

    
}
