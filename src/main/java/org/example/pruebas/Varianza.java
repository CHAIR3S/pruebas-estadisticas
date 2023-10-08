package org.example.pruebas;

import org.example.MatrizCuadrada;
import org.example.utils.Operations;

public class Varianza {
    private double[][] matriz;
    private Operations oper;


    public void realizarPrueba( double alpha ){ // alpha = nivel significancia
        double promedio = oper.promediarDatosMatriz(matriz),
                alphaMedios = alpha / 2;

    }

    private double calcularVarianza( double promedio ){
        double[][] datosVarianza = new double[matriz.length][matriz.length];
        int indexH, indexV;

        for ( indexV = 0; indexV < matriz.length; indexV++) {
            for ( indexH = 0; indexH < matriz.length; indexH++) {
                datosVarianza[indexV][indexH] = Math.pow((  matriz[indexV][indexH] ),2);
            }
        }

        double sumaDatos = oper.sumarDatosMatriz(datosVarianza);

        return (sumaDatos / ( matriz.length * matriz.length - 1 ));
    }



    Varianza(MatrizCuadrada datos ){
        matriz = datos.matriz;
        oper = new Operations();
    }
}
