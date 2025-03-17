package com.grupposad.esercitazione1703.calculator.operation;

public class SinOperation extends Operation {

    @Override
    public Double calculate(Double a, Double b) {
        if (a == null) {
            throw new IllegalArgumentException("Errore: Il valore di input non può essere nullo.");
        }

        double radians = Math.toRadians(a); 
        return Math.sin(radians);
    }

    @Override
    public String getSymbol() {
        return "sin";
    }
}
