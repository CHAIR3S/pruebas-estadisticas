package org.example.pruebas;

import org.example.MatrizCuadrada;
import org.example.distribuciones.ChiSquared;
import org.example.utils.Operations;

public class Varianza {
    private final Operations oper;
    private ChiSquared chiSquared;
    private final double[][] matriz;
    private double varianza, limitInfe, limitSup;
    private String h0 , h1, criterio;


    public void realizarPrueba( double alfa ){ // alpha = nivel significancia
        double promedio = oper.promediarDatosMatriz(matriz),
                alfaMedios = alfa / 2;

        calcularVarianza(promedio);
        calcularLimites( alfaMedios, true);
        calcularLimites( alfaMedios, false);

        mostrarConclusion();
    }

    private void calcularVarianza( double promedio ){
        double[][] datosVarianza = new double[matriz.length][matriz.length];
        int indexH, indexV;

        for ( indexV = 0; indexV < matriz.length; indexV++) {
            for ( indexH = 0; indexH < matriz.length; indexH++) {
                datosVarianza[indexV][indexH] = Math.pow(( matriz[indexV][indexH] - promedio ), 2 );
            }
        }

        double sumaDatos = oper.sumarDatosMatriz(datosVarianza);

        varianza =  (sumaDatos / ( matriz.length * matriz.length - 1 ));
    }

    private void calcularLimites( double alfaMedios, Boolean isLimitInfe ) {
        double valorChiSquared = isLimitInfe
                                    ? chiSquared.obtenerValor(alfaMedios)
                                    : chiSquared.obtenerValor((1-alfaMedios));

        if( isLimitInfe )limitInfe = valorChiSquared / (12 * ( oper.contarDatosMatriz(matriz) - 1 ));
        else limitSup = valorChiSquared / (12 * ( oper.contarDatosMatriz(matriz) - 1 ));
    }

    private void mostrarConclusion(){
        System.out.println("----------HIPOTESIS-----------");
        System.out.println(h0 + "\n" + h1 + "\n");
        System.out.println("---------CRITERTIO------------");
        System.out.println(criterio + "\n");
        System.out.println("VARIANZA CALCULADA: " + varianza + "\n");
        System.out.println("----------LIMITES-------------");
        System.out.println("LIMITE INFERIOR: " + limitInfe);
        System.out.println("LIMITE SUPERIOR: " + limitSup + "\n");

        System.out.println("---------CONCLUSIÓN-----------");
        if( varianza > limitInfe && varianza < limitSup ) System.out.println("No se puede rechazar h0, por lo tanto los números tienen una varianza de 1/12");
        else System.out.println("No se puede rechazar h0, por lo tanto los números tienen una varianza de 1/12");
    }


    public Varianza(MatrizCuadrada datos, ChiSquared chiSquared ){
        this.chiSquared = chiSquared;
        matriz = datos.matriz;
        oper = new Operations();
        varianza = 0;
        limitInfe = 0;
        limitSup = 0;
        h0 = "H0: Los números ri, tienen una varianza de 1/12";
        h1 = "H1: Los números ri, NO tienen una varianza de 1/12";
        criterio = "Si el valor de la varianza muestral se encuentra entre los límites inferior y superior, no se puede rechazar Ho";
    }
}
