package org.example.pruebas;

import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.example.MatrizCuadrada;
import org.example.utils.Operations;

public class Uniformidad {

    private double[][] matriz;
    
    private Operations oper = new Operations();
    
    private int n;
    
    private int m;
    
    private double ancho;
    
    private int[] Oi;
    
    private double Ei;
    
    private double chi2=0;
    
    private double Z = 0;
    
    private String h0 = "Los números ri siguen una distribución uniforme entre cero y uno";
    
    private String h1 = "Los números ri NO siguen una distribución uniforme entre cero y uno";
    
    private String criterio = "Si el valor de Chi cuadrada es menor a Chi cuadrada de alfa,m-1, entonces no se puede rechazar Ho";

	public Uniformidad(MatrizCuadrada pMatriz) {
		this.matriz = pMatriz.matriz;
		this.n = oper.contarDatosMatriz(this.matriz);
		this.m = (int) Math.ceil(Math.sqrt(n));
		this.Ei = n/m;
		this.ancho = 1.0/m;
	}
	
	
	public void realizarPrueba(double alfa) {
		
		obtenerOi();
		obtenerChi2();
		obtenerZ(alfa, m-1);
		mostrarConclusion();
	}
	
	private void obtenerOi() {
		Oi = new int[m];
		
		for(int i = 0; i<matriz.length; i++) {
			for(int j = 0; j<matriz[0].length; j++) {
				int iteracion = 1;
				for(int intervalo = 0; intervalo<m; intervalo++) {
					if(matriz[i][j] <= (iteracion*ancho)) {
						Oi[intervalo]++;
						intervalo = m;
					}
					iteracion++;
				}
			}
		}
	}
	
	
	private void obtenerChi2() {
		chi2 = 0;
		for(int oi : Oi) {
			double elevate = Ei-oi;
			chi2+=(Math.pow(elevate, 2))/Ei;
		}
	}
	
	private void obtenerZ(double alfa, int gradosDeLibertad) {
		ChiSquaredDistribution chiSquared = new ChiSquaredDistribution(gradosDeLibertad);
		Z = oper.redondearTresDecimales(chiSquared.inverseCumulativeProbability(1-alfa));
	}

	
    private void mostrarConclusion(){
        System.out.println("----------HIPOTESIS-----------");
        System.out.println(h0 + "\n" + h1 + "\n");
        System.out.println("---------CRITERTIO------------");
        System.out.println(criterio + "\n");
        System.out.println("----------VALORES-------------");
        System.out.println("n: " + n);
        System.out.println("m: " + m);
        System.out.println("ancho: " + ancho + "\n");
        System.out.println("----------Oi-------------");
        int iteracion = 0;
        for(int oi : Oi) {
        	System.out.print("Intervalo " + iteracion*ancho + " - ");
        	iteracion++;
        	System.out.println(iteracion*ancho + "\tOi: " + oi);
        }
        System.out.println();
        System.out.println("----------CHI2-------------");
        System.out.println("CHI2 calculada: " + chi2);
        System.out.println("CHI2(Alfa, m-1): " + Z + "\n");

        System.out.println("---------CONCLUSIÓN-----------");
        if( chi2<Z ) System.out.println("NO se rechaza ho, por lo tanto, los números ri, siguen una distribución uniforme entre cero y uno");
        else System.out.println("Se rechaza h0, por lo tanto, los números ri, NO siguen una distribución uniforme entre cero y uno");
    }
	

	public double[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(double[][] matriz) {
		this.matriz = matriz;
	}


	public int getN() {
		return n;
	}


	public void setN(int n) {
		this.n = n;
	}


	public int getM() {
		return m;
	}


	public void setM(int m) {
		this.m = m;
	}


	public double getAncho() {
		return ancho;
	}


	public void setAncho(double ancho) {
		this.ancho = ancho;
	}


	public int[] getOi() {
		return Oi;
	}


	public void setOi(int[] oi) {
		Oi = oi;
	}


	public double getEi() {
		return Ei;
	}


	public void setEi(double ei) {
		Ei = ei;
	}


	public double getChi2() {
		return chi2;
	}


	public void setChi2(double chi2) {
		this.chi2 = chi2;
	}


	public double getZ() {
		return Z;
	}


	public void setZ(double z) {
		Z = z;
	}
	
	
	
}
