package com.grupposad.esercitazione1703.calculator.operation;

public class DivideOperation extends Operation {
    @Override
    public Double calculate(Double a, Double b) {
        if (b == null || b == 0) {
            throw new ArithmeticException("Errore: Divisione per zero non consentita.");
        }
        return a / b;
    }

    @Override
    public String getSymbol() {
        return "/";
    }
}
