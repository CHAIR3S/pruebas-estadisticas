package org.example;

import org.example.distribuciones.ChiSquared;
import org.example.pruebas.Uniformidad;
import org.example.pruebas.Independencia;
import org.example.pruebas.Media;
import org.example.pruebas.Varianza;
import java.util.Scanner;

//import javax.print.attribute.standard.Media;

class Main {
    public static void main(String[] args) {
        // INSTANCIAS DE LAS PRUEBAS
        Varianza varianza;
        Uniformidad uniformidad;
        Media media;
        Independencia independencia;

        // INSTANCIAS DE LAS DISTRIBUCIONES
        ChiSquared chiSquared;

        Scanner scanner = new Scanner(System.in);
        // INGRESAR MÉTODO REQUERIDO
        int opcionSeleccionada;
        int cantidadDeDatos;
        double nivelSignificancia;

        do {
            System.out.print(
                    "\n---------------------------------\nTENIENDO LAS SIGUIENTES OPCIONES, INGRESE EL NÚMERO DE MÉTODO A EVALUAR: \n1.- Prueba de media \n2.- Prueba de varianza \n3.- Prueba de uniformidad \n4.- Prueba de independencia \n\nEscriba el número a continuación: ");
            opcionSeleccionada = scanner.nextInt();
        } while (opcionSeleccionada < 1 || opcionSeleccionada > 4);

        // INGRESAR CANTIDAD DE DATOS Y VERIFICAR QUE SEA MATRIZ CUADRADA
        do {
            System.out.print(
                    "Ingrese la cantidad de datos a evaluar (Raíz cuadrada exacta): ");
            cantidadDeDatos = scanner.nextInt();
        } while (Math.sqrt(cantidadDeDatos) != (int) Math.round(Math.sqrt(cantidadDeDatos)));

        System.out.print("Ingrese el nivel de significancia: ");
        nivelSignificancia = scanner.nextDouble();

        // INGRESAR DATOS
        // MatrizCuadrada matriz = new MatrizCuadrada((int) Math.sqrt(cantidadDeDatos));
        // matriz.leerdatos(scanner);

        // MATRIZ DE PRUEBA
        MatrizCuadrada matrizCuadradaPrueba = new MatrizCuadrada(16);
        double[][] matrizPrueba = { { .32, .726, .342, .016 }, { .018, .567, .515, .476 }, { .671, .302, .876, .854 },
                { .083, .516, .524, .976 } };
        matrizCuadradaPrueba.setMatriz(matrizPrueba);

        // INICIALIZACIÓN DE LAS INTANCIAS DE LAS PRUEBAS
        chiSquared = new ChiSquared(cantidadDeDatos);
        varianza = new Varianza(matrizCuadradaPrueba, chiSquared);
        uniformidad = new Uniformidad(matrizCuadradaPrueba);
        independencia = new Independencia(matrizCuadradaPrueba);

        media = new Media(matrizCuadradaPrueba);

        // SELECCIONAR MÉTODO Y HACERLO FUNCIONAR
        switch (opcionSeleccionada) {
            // Prueba de media
            case 1:
                media.realizarPrueba(nivelSignificancia);
                break;
            // Prueba de varianza
            case 2:
                varianza.realizarPrueba(nivelSignificancia);
                break;
            // Prueba de uniformidad
            case 3:
                uniformidad.realizarPrueba(nivelSignificancia);
                break;
            // Prueba de indecencia
            case 4:
                independencia.realizarPrueba(nivelSignificancia);
                break;
        }

        // MOSTRAR MATRIZ ORIGINAL
        System.out.println("--------MATRÍZ INGRESADA--------");
        matrizCuadradaPrueba.imprimirMatriz();

        scanner.close();
    }
}
