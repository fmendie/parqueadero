/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package parqueaderos;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
public class ParqueaderoNGTest {
    
    public ParqueaderoNGTest() {
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
     * Test of registrarEntrada method, of class Parqueadero.
     */
    @Test
public void testRegistrarEntrada() {
    System.out.println("registrarEntrada");
    Parqueadero instance = new Parqueadero();
    Vehiculo vehiculo = new Vehiculo("ABC123", "Toyota", "Corolla");

    instance.registrarEntrada(vehiculo);
    
    // Capturar la salida de consola
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    instance.consultarEstado();

    System.setOut(System.out); // Restaurar salida estándar
    String output = outContent.toString();

    assertTrue(output.contains("ABC123"), "El estado debe contener la placa del vehículo registrado.");
}


@Test
public void testRegistrarSalida() {
    System.out.println("registrarSalida");
    Parqueadero instance = new Parqueadero();
    Vehiculo vehiculo = new Vehiculo("ABC123", "Toyota", "Corolla");
    
    instance.registrarEntrada(vehiculo);
    try {
        Thread.sleep(1000); // Esperar 1 segundo para asegurar un cambio de tiempo
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
    double tarifa = instance.registrarSalida("ABC123");
    
    assertTrue(tarifa > 0, "La tarifa debe ser mayor a 0, pero fue: " + tarifa);
}


    /**
     * Test of consultarEstado method, of class Parqueadero.
     */
   @Test
public void testConsultarEstado() {
    System.out.println("consultarEstado");
    Parqueadero instance = new Parqueadero();
    Vehiculo vehiculo = new Vehiculo("XYZ789", "Honda", "Civic");

    instance.registrarEntrada(vehiculo);

    // Capturar la salida de consola
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    instance.consultarEstado();

    System.setOut(System.out); // Restaurar salida estándar
    String output = outContent.toString();

    assertTrue(output.contains("XYZ789"), "El estado debe mostrar la placa del vehículo ingresado.");
}


@Test
public void testGenerarReporteDelDia() {
    System.out.println("generarReporteDelDia");
    Parqueadero instance = new Parqueadero();
    Vehiculo vehiculo = new Vehiculo("LMN456", "Ford", "Focus");

    instance.registrarEntrada(vehiculo);
    instance.registrarSalida("LMN456");

    // Capturar la salida de consola
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    instance.generarReporteDelDia();

    System.setOut(System.out); // Restaurar salida estándar
    String output = outContent.toString();

    assertTrue(output.contains("LMN456"), "El reporte debe contener la placa del vehículo registrado.");
}

    
}
