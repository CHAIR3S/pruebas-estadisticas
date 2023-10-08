package org.example;


import org.apache.commons.math3.distribution.ChiSquaredDistribution;
        import org.apache.commons.math3.distribution.RealDistribution;
        import org.apache.commons.math3.exception.NotStrictlyPositiveException;

public class Main {

    public static void main(String[] args) {
        double degreesOfFreedom = 15;

        RealDistribution chiSquaredDistribution = new ChiSquaredDistribution(degreesOfFreedom);

        double x = 0.05;
        double cdf = chiSquaredDistribution.inverseCumulativeProbability(1 - 0.05);
        System.out.println(cdf);

    }
}