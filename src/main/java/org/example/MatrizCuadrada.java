package org.example;

import java.util.Scanner;

public class MatrizCuadrada {
    int numeroBase, sumaDatos, promedioDatos;
    public double[][] matriz = { { .320, .726, .342, .016 },
            { .018, .567, .515, .476 },
            { .671, .302, .876, .854 },
            { .083, .516, .524, .976 } };

    MatrizCuadrada(int p_numeroBase) {
        this.numeroBase = p_numeroBase;
        this.matriz = new double[p_numeroBase][p_numeroBase];
    }

    public void setMatriz(double[][] matriz) {
        this.matriz = matriz;
    }

    void imprimirMatriz() {
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                System.out.print("\t" + matriz[fila][columna] + "\t");
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
