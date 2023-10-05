package utils;

public class Operations {

  public double sumarDatosMatriz( double[][] matriz ){
    double suma = 0;
    int indexV, indexH;

    for ( indexV = 0; indexV < matriz.length; indexV++) {
        for ( indexH = 0; indexH < matriz.length; indexH++) {
            suma += matriz[indexV][indexH];
        }
    }

    return suma;
  }

  public double promediarDatosMatriz( double[][] matriz ){
    double suma = sumarDatosMatriz(matriz);

    return ( suma / ( matriz.length * matriz.length ));
  }
}
