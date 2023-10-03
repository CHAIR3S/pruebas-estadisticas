import java.util.Scanner;

class MatrizCuadrada {
    int numeroBase;
    int[][] matriz;

    MatrizCuadrada(int p_numeroBase) {
        this.numeroBase = p_numeroBase;
        this.matriz = new int[p_numeroBase][p_numeroBase];
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
                matriz[fila][columna] = scanner.nextInt();
            }
        }
        scanner.close();
    }
}