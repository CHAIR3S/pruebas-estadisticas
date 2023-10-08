package org.example.pruebas;

import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.distribution.RealDistribution;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;

public class Independencia {
    double nivelInsignificancia;
    double conjunto_de_numeros[][];

    //El valor de independencia es double
    Independencia(double conjunto_de_numeros[][], double nivelInsignificancia){
        this.nivelInsignificancia = nivelInsignificancia;
        this.conjunto_de_numeros = conjunto_de_numeros;
    }

    void realizarPrueba(){
        String secuencia = calcularSecuencia(this.conjunto_de_numeros);
        int Co = calcular_CO(secuencia);
        double UCo = calcular_UCo(this.conjunto_de_numeros.length);
        double OCo = calcular_OCo(this.conjunto_de_numeros.length);

        double Zo = Zo(Co, UCo, OCo);
        double Za_2 = Za_2();
        //IMprime los resultados

        //Evalúa cuál es la conclusión 
        if(Zo > Za_2){
            System.out.println("Los números del conjunto Ri no son independientes");
        }else{
            System.out.println("Los números del conjunto Ri son independientes");
        }
    }

    String calcularSecuencia(double[][] conjunto_de_numeros){
        int longitud = conjunto_de_numeros.length;
        String secuencia = "";
        int colNumSiguiente;
        int filNumSiguiente;

        for (int filas = 0; filas < longitud; filas++) {
            for (int columnas = 0; columnas < longitud; columnas++) {
                if(filas == longitud-1 && columnas == longitud-1){
                    return secuencia;
                }

                if(columnas == longitud-1){
                    colNumSiguiente = 0;
                    filNumSiguiente = filas+1;
                }else{
                    colNumSiguiente = columnas+1;
                    filNumSiguiente = filas;
                }

                if(Double.compare(conjunto_de_numeros[filas][columnas], conjunto_de_numeros[filNumSiguiente][colNumSiguiente]) < 0){
                    secuencia += "1";
                }else{
                    secuencia += "0";
                }
            }
        }
        return secuencia;
    }

    int calcular_CO(String secuencia){
        int Co = 0;
        for (int indexSecuencia = 0; indexSecuencia < secuencia.length()-1; indexSecuencia++) {
            if(secuencia.charAt(indexSecuencia) != secuencia.charAt(indexSecuencia+1)){
                Co++;
            }
        }
        if(secuencia.charAt(secuencia.length()-1) != secuencia.charAt(secuencia.length()-2)){
            Co++;
        }
        return Co;
    }

    double calcular_UCo(int n){
        return Double.valueOf((2.0*n -1)/3.0);
    }

    double calcular_OCo(int n){
        return Math.sqrt((16.0*n -29)/90);
    }

    double Zo(int Co, double UCo, double OCo){
        double resultado = (Co - UCo)/OCo;
        if(resultado < 0){
            resultado *= -1;
        }
        return resultado;
    }

    double Za_2(){
        double degreesOfFreedom = conjunto_de_numeros.length-1;
        RealDistribution chiSquaredDistribution = new ChiSquaredDistribution(degreesOfFreedom);

        double a_2 = nivelInsignificancia/2;
        double cdf = chiSquaredDistribution.inverseCumulativeProbability(1 - a_2);
        return cdf;
    };

}
