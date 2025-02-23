Descripción

Este es un sistema de gestión de parqueadero desarrollado en Java que permite registrar la entrada y salida de vehículos, consultar el estado del parqueadero y generar un reporte diario de los vehículos que han ingresado y salido.

Requisitos

Java 8 o superior

NetBeans (opcional, pero recomendado para su ejecución y desarrollo)

TestNG para ejecutar las pruebas unitarias

Se suben 2 carpetas al repositorio
src ---> SourcePackages
5 archivos

Automóvil.java
Camion.java
GestionParqueadero.java
Motocicleta.java
Vehiculo.java

Compila y ejecuta la clase GestionParqueadero.


test---> Archivos de prueba
5 archivos 

AutomóvilNGTest.java
CamionNGTest.java
GestionParqueaderoNGTest.java
MotocicletaNGTest.java
VehiculoNGTest.java

Al ejecutar cada uno se realizan las pruebas de cada clase

Uso

Cuando ejecutes la aplicación, verás un menú con las siguientes opciones:

Registrar entrada de vehículo

Ingresa la placa, marca, modelo y selecciona el tipo de vehículo.

Se guardará el vehículo en el sistema y quedará registrado en el parqueadero.

 Registrar salida de vehículo

Ingresa la placa del vehículo a retirar.

Se calculará la tarifa según el tiempo de permanencia y el tipo de vehículo.

El vehículo se eliminará del estado actual del parqueadero, pero quedará en el historial.

Consultar estado del parqueadero

Muestra la lista de los vehículos actualmente estacionados.

Generar reporte del día

Muestra todos los vehículos que han ingresado y salido durante la jornada.

Salir

Finaliza la ejecución del programa.

