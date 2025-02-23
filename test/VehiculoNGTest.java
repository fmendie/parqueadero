/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package parqueaderos;

import java.time.LocalDateTime;
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
public class VehiculoNGTest {
    
    public VehiculoNGTest() {
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

    /**
     * Test of getPlaca method, of class Vehiculo.
     */
    @Test
public void testGetPlaca() {
    Vehiculo instance = new Vehiculo("ABC123", "Toyota", "Corolla");
    assertEquals(instance.getPlaca(), "ABC123");
}

@Test
public void testGetMarca() {
    Vehiculo instance = new Vehiculo("ABC123", "Toyota", "Corolla");
    assertEquals(instance.getMarca(), "Toyota");
}

@Test
public void testGetModelo() {
    Vehiculo instance = new Vehiculo("ABC123", "Toyota", "Corolla");
    assertEquals(instance.getModelo(), "Corolla");
}

@Test
public void testGetHoraEntrada() {
    System.out.println("getHoraEntrada");
    Vehiculo instance = new Vehiculo("ABC123", "Toyota", "Corolla");
    LocalDateTime esperado = instance.getHoraEntrada(); // Se inicializa en el constructor
    assertNotNull(esperado); // Verifica que no sea null
}


@Test
public void testSetHoraSalida() {
    Vehiculo instance = new Vehiculo("ABC123", "Toyota", "Corolla");
    LocalDateTime salida = LocalDateTime.now().plusHours(2);
    instance.setHoraSalida(salida);
    assertEquals(instance.getHoraSalida(), salida);
}

    
}
