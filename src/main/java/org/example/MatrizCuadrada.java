package org.example;

import java.util.Scanner;

public class MatrizCuadrada {
    int numeroBase, sumaDatos, promedioDatos;
    public double[][] matriz;

    MatrizCuadrada(int p_numeroBase) {
        this.numeroBase = p_numeroBase;
        this.matriz = new double[p_numeroBase][p_numeroBase];
    }

    void imprimirMatriz() {
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                System.out.printf("%4d", matriz[fila][columna]);
            }
            System.out.println();
        }
    }

    void leerdatos(Scanner scanner) {

        for (int fila = 0; fila < numeroBase; fila++) {
            for (int columna = 0; columna < numeroBase; columna++) {
                System.out
                        .println(
                                "Ingrese el valor de la columna " + (columna + 1) + " de la fila " + (fila + 1) + ": ");
                matriz[fila][columna] = scanner.nextDouble();
            }
        }
        scanner.close();
    }

}
