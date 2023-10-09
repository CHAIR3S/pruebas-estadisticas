package org.example.pruebas;

import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.RealDistribution;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.example.MatrizCuadrada;

public class Independencia {
    MatrizCuadrada conjunto_de_numeros;

    public Independencia(MatrizCuadrada matriz){
        this.conjunto_de_numeros = matriz;
    }

    public void realizarPrueba(double nivelInsignificancia){
        String secuencia = calcularSecuencia(this.conjunto_de_numeros);
        int Co = calcular_CO(secuencia);
        double UCo = calcular_UCo(this.conjunto_de_numeros.matriz.length*this.conjunto_de_numeros.matriz.length);
        double OCo = calcular_OCo(this.conjunto_de_numeros.matriz.length*this.conjunto_de_numeros.matriz.length);

        double Zo = Zo(Co, UCo, OCo);
        //double Za_2 = Za_2(nivelInsignificancia);
        double Za_2 = calculoValorZ(nivelInsignificancia/2);

        //Imprime los resultados
        System.out.println("\n\n----------Datos de la prueba de independencia----------");
        System.out.println("\nCo: "+Co);
        System.out.println("UCo: "+UCo);
        System.out.println("OCo: "+OCo+"\n");

        //Evalúa cuál es la conclusión 
        if(Zo > Za_2){
            System.out.println("Zo:"+ Zo +" es mayor que el valor crítico Zalfa/2: "+Za_2);
            System.out.println("Conclusión: Los números del conjunto Ri no son independientes");
        }else{
            System.out.println("Zo:"+ Zo +" es menor que el valor crítico Zalfa/2: "+Za_2);
            System.out.println("Conclusión: Los números del conjunto Ri sí son independientes");
        }System.out.println();
    }

    String calcularSecuencia(MatrizCuadrada conjunto_de_numeros){
        int longitud = conjunto_de_numeros.matriz.length;
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

                if(Double.compare(conjunto_de_numeros.matriz[filas][columnas], conjunto_de_numeros.matriz[filNumSiguiente][colNumSiguiente]) < 0){
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
        return Co+1;
    }

    double calcular_UCo(int n){
        System.out.println("n: "+n);
        System.out.println(Double.valueOf((2.0*n -1)/3.0));
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

    double Za_2(double nivelInsignificancia){
        double degreesOfFreedom = conjunto_de_numeros.matriz.length-1;
        RealDistribution chiSquaredDistribution = new ChiSquaredDistribution(degreesOfFreedom);

        double a_2 = nivelInsignificancia/2;
        double cdf = chiSquaredDistribution.inverseCumulativeProbability(1 - a_2);
        return cdf;
    };

    double calculoValorZ(double nivelInsignificancia){
        nivelInsignificancia = 1 - nivelInsignificancia;

        NormalDistribution nd = new NormalDistribution(0,1);
        double NumeroZ = nd.inverseCumulativeProbability(nivelInsignificancia);
        return NumeroZ;
        
    }

}
