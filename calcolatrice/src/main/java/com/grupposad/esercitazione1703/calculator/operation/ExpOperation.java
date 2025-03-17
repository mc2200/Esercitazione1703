package com.grupposad.esercitazione1703.calculator.operation;

public class ExpOperation extends Operation {

    @Override
    public Double calculate(Double a, Double b) {
        // b: base, a: exponent
        return Math.exp(b * Math.log(a));
    }

    @Override
    public String getSymbol() {
        return "exp";
    }
}