package org.example.pruebas;

import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.example.utils.Operations;

public class Uniformidad {

    private double[][] matriz;
    
    private Operations oper;
    
    private int n;
    
    private int m;
    
    private double ancho;
    
    private int[] Oi;
    
    private double Ei;
    
    private double chi2=0;
    
    private double Z = 0;

	public Uniformidad(double[][] matriz) {
		this.matriz = matriz;
		this.n = oper.contarDatosMatriz(matriz);
		this.m = (int) Math.ceil(Math.sqrt(n));
		this.ancho = 1/this.m;
		this.Ei = n/m;
	}
	
	
	public void realizarPrueba(double alfa) {
		obtenerOi();
		obtenerChi2();
		obtenerZ(alfa, m-1);
	}
	
	private void obtenerOi() {
		Oi = new int[m];
		
		for(int i = 0; i<matriz.length; i++) {
			for(int j = 0; j<matriz[0].length; j++) {
				for(int intervalo = 1; intervalo<=m; intervalo++) {
					int index = 0;
					if(matriz[i][j] <= ancho*intervalo) {
						Oi[index] = Oi[index]+1;
						intervalo = 1+m;
					}
					index++;
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
		Z = chiSquared.inverseCumulativeProbability(1-alfa);
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
