package org.example.pruebas;

import org.example.MatrizCuadrada;
import org.example.utils.Operations;
import org.apache.commons.math3.distribution.NormalDistribution;

public class Media {
    double Matriz [][];
    static int CantidadMatrizRi;
    double limiteS;
    double limiteI;
    double suma = 0;
    double media;
    double NumeroZ;
    double alfaMitad;
    private Operations operations = new Operations();

    public Media(MatrizCuadrada datos){
        Matriz = datos.matriz;
        limiteI = 0;
        limiteS = 0;
    }

    public void realizarPrueba(double alfa){
        suma = operations.sumarDatosMatriz(Matriz);
        System.out.println("");
        System.out.println("La suma de los datos ingresados es: " + suma);
        media = operations.promediarDatosMatriz(Matriz);
        System.out.println("");
        System.out.println("La media de los datos ingresados es: " + media);
        alfaMitad = alfa/2;
        calculoValorZ(alfaMitad);
        calculoLimites();
        Conclusiones();

    }

    public void calculoValorZ(double numeroAlfa){
        numeroAlfa = 1 - numeroAlfa;

        NormalDistribution nd = new NormalDistribution(0,1);
        NumeroZ = nd.inverseCumulativeProbability(numeroAlfa);
        System.out.println("");
        System.out.println("El valor de z que corresponde con el numero alfa dado es: " + NumeroZ);
        
    }

    public void calculoLimites(){

        double desviacionEstandar = 1.0 / Math.sqrt(12 * operations.contarDatosMatriz(Matriz));
        limiteI = 0.5 - NumeroZ * desviacionEstandar;
        limiteS = 0.5 + NumeroZ * desviacionEstandar;
        System.out.println("");
        System.out.println("El limite Inferior es : " + limiteI);
        System.out.println("El limite superior es : " + limiteS);

    }

    public void Conclusiones(){
        System.out.println("");
        System.out.println("---------------------------CONCLUSION---------------------------");
        if(limiteI < media && limiteS > media ){
            System.out.println("No se puede rechazar H0. Por lo tanto el promedio de los numeros ri, si es 0.5");
        }
        else
            System.out.println("Se rechaza H0, Por lo tanto el promedio de los numeros ri, no es 0.5");
    }
}


