/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parqueaderos;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pipe7
 */
class Parqueadero {
    private List<Vehiculo> vehiculos;
    private List<Vehiculo> historialVehiculos;
    private static final double TARIFA_AUTOMOVIL = 5000;
    private static final double TARIFA_MOTOCICLETA = 3000;
    private static final double TARIFA_CAMION = 10000;
    
    public Parqueadero() {
        vehiculos = new ArrayList<>();
        historialVehiculos = new ArrayList<>();
    }
    
    public void registrarEntrada(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
        historialVehiculos.add(vehiculo);
        System.out.println("Vehículo registrado: " + vehiculo.getPlaca());
    }
    
    public double registrarSalida(String placa) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                vehiculo.setHoraSalida(LocalDateTime.now());
                long horas = Duration.between(vehiculo.getHoraEntrada(), vehiculo.getHoraSalida()).toHours();
                if (horas == 0) horas = 1;
                
                double costo = 0;
                if (vehiculo instanceof Automovil) costo = horas * TARIFA_AUTOMOVIL;
                else if (vehiculo instanceof Motocicleta) costo = horas * TARIFA_MOTOCICLETA;
                else if (vehiculo instanceof Camion) costo = horas * TARIFA_CAMION;
                
                vehiculos.remove(vehiculo);
                System.out.println("Salida registrada: " + placa + " - Costo: $" + costo);
                return costo;
            }
        }
        System.out.println("Vehículo no encontrado.");
        return 0;
    }
    
    public void consultarEstado() {
        if (vehiculos.isEmpty()) {
            System.out.println("El parqueadero está vacío.");
        } else {
            System.out.println("Vehículos en el parqueadero:");
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println("Placa: " + vehiculo.getPlaca() + ", Marca: " + vehiculo.getMarca() + ", Modelo: " + vehiculo.getModelo());
            }
        }
    }
    
    public void generarReporteDelDia() {
        System.out.println("Reporte de vehículos del día:");
        for (Vehiculo vehiculo : historialVehiculos) {
            System.out.println("Placa: " + vehiculo.getPlaca() + ", Marca: " + vehiculo.getMarca() + ", Modelo: " + vehiculo.getModelo() + ", Hora de entrada: " + vehiculo.getHoraEntrada() + ", Hora de salida: " + (vehiculo.getHoraSalida() != null ? vehiculo.getHoraSalida() : "Aún en parqueadero"));
        }
    }
}

// Clase principal con método main
public class GestionParqueadero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero();
        
        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Registrar entrada de vehículo");
            System.out.println("2. Registrar salida de vehículo");
            System.out.println("3. Consultar estado del parqueadero");
            System.out.println("4. Generar reporte del día");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Ingrese marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.println("Seleccione tipo de vehículo: 1. Automóvil 2. Motocicleta 3. Camión");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();
                    
                    Vehiculo vehiculo = null;
                    if (tipo == 1) {
                        System.out.print("Ingrese tipo de combustible: ");
                        String tipoCombustible = scanner.nextLine();
                        vehiculo = new Automovil(placa, marca, modelo, tipoCombustible);
                    } else if (tipo == 2) {
                        System.out.print("Ingrese cilindraje: ");
                        int cilindraje = scanner.nextInt();
                        vehiculo = new Motocicleta(placa, marca, modelo, cilindraje);
                    } else if (tipo == 3) {
                        System.out.print("Ingrese capacidad de carga en toneladas: ");
                        double capacidadCarga = scanner.nextDouble();
                        vehiculo = new Camion(placa, marca, modelo, capacidadCarga);
                    }
                    if (vehiculo != null) {
                        parqueadero.registrarEntrada(vehiculo);
                    }
                    break;
                
                case 2:
                    System.out.print("Ingrese la placa del vehículo a retirar: ");
                    String placaSalida = scanner.nextLine();
                    parqueadero.registrarSalida(placaSalida);
                    break;
                
                case 3:
                    parqueadero.consultarEstado();
                    break;
                
                case 4:
                    parqueadero.generarReporteDelDia();
                    break;
                
                case 5:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}

