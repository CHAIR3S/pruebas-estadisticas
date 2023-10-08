package org.example.distribuciones;


import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.distribution.RealDistribution;

public class ChiSquared {
        private final RealDistribution chiSquaredDistribution;

        public double obtenerValor( double alfa ){
                return chiSquaredDistribution.inverseCumulativeProbability(alfa);
        }
        public ChiSquared( int degreesOfFreedom ){
                chiSquaredDistribution = new ChiSquaredDistribution(degreesOfFreedom);
        }
}