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
                    "\n---------------------------------\nTENIENDO LAS SIGUIENTES OPCIONES, INGRESE EL NÚMERO DE MÉTODO A EVALUAR: \n1.- Prueba de media \n2.- Prueba de varianza \n3.- Prueba de uniformidad \n4.- Prueba de indecencia \n\nEscriba el número a continuación: ");
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
        MatrizCuadrada matriz = new MatrizCuadrada((int) Math.sqrt(cantidadDeDatos));
        matriz.leerdatos(scanner);

        // INICIALIZACIÓN DE LAS INTANCIAS DE LAS PRUEBAS
        chiSquared = new ChiSquared(cantidadDeDatos);
        varianza = new Varianza( matriz, chiSquared );
        uniformidad = new Uniformidad(matriz);
        independencia = new Independencia(matriz);

        media = new Media(matriz);

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
        matriz.imprimirMatriz();

        scanner.close();
    }
}
