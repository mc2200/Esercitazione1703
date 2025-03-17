package com.grupposad.esercitazione1703.calculator.operation;

public class MultiplyOperation extends Operation {
    @Override
    public Double calculate(Double a, Double b) {
        return a * b;
    }

    @Override
    public String getSymbol() {
        return "*";
    }
}
