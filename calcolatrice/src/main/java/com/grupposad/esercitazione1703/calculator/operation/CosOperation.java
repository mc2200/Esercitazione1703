package com.grupposad.esercitazione1703.calculator.operation;

public class CosOperation extends Operation {

    @Override
    public Double calculate(Double a, Double b) {
        // a: degrees
        double radians = Math.toRadians(a); 
        return Math.cos(radians);
    }

    @Override
    public String getSymbol() {
        return "cos";
    }
}