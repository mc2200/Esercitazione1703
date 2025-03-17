package com.grupposad.esercitazione1703.calculator.operation;

public class LogOperation extends Operation {

    @Override
    public Double calculate(Double a, Double b) {
        // a: argument, b: base
        return Math.log(a) / Math.log(b);
    }

    @Override
    public String getSymbol() {
        return "log";
    }
}