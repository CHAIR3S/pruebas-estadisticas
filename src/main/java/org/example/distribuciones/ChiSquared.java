package org.example.distribuciones;


import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.distribution.RealDistribution;

public class ChiSquared {


        double degreesOfFreedom = 15;

        RealDistribution chiSquaredDistribution = new ChiSquaredDistribution(degreesOfFreedom);

        double x = 0.05;
        double cdf = chiSquaredDistribution.inverseCumulativeProbability(1 - 0.05);



}