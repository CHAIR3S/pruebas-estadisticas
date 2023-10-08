import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // INGRESAR MÉTODO REQUERIDO
        int opcionSeleccionada;
        int cantidadDeDatos;
        float nivelInsignificancia;

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

        System.out.println("Ingrese el nivel de significancia: ");
        nivelInsignificancia = scanner.nextFloat();

        // INGRESAR DATOS (Esta matriz debía ser de doubles)
        MatrizCuadrada matriz = new MatrizCuadrada((int) Math.sqrt(cantidadDeDatos));
        matriz.leerdatos(scanner);

        // SELECCIONAR MÉTODO Y HACERLO FUNCIONAR
        switch (opcionSeleccionada) {
            // Prueba de media
            case 1:
                
                break;
            // Prueba de varianza
            case 2:

                break;
            // Prueba de uniformidad
            case 3:
                
                break;
            // Prueba de indecencia
            case 4:
                double conjunto_de_numeros[][] = {
                    {0.937, 0.939, 0.069, 0.742, 0.082},
                    {0.173, 0.953, 0.149, 0.235, 0.842},
                    {0.562, 0.727, 0.333, 0.552, 0.448},
                    {0.110, 0.060, 0.659, 0.842, 0.479},
                    {0.410, 0.640, 0.578, 0.482, 0.649}
                };
                Prueba_Independencia metodo = new Prueba_Independencia(conjunto_de_numeros, 0);
                metodo.realizarPrueba();
                break;
        }

        // MOSTRAR MATRIZ ORIGINAL
        System.out.println("--------MATRÍZ INGRESADA--------");
        matriz.imprimirMatriz();

        scanner.close();
    }
}
