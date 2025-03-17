package com.grupposad.esercitazione1703.calculator.operation;

public class ExpOperation extends Operation {

    @Override
    public Double calculate(Double a, Double b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Errore: I valori di base ed esponente non possono essere nulli.");
        }

        if (a <= 0) {
            throw new ArithmeticException("Errore: La base deve essere positiva per evitare numeri complessi.");
        }

        return Math.exp(b * Math.log(a));
    }

    @Override
    public String getSymbol() {
        return "exp";
    }
}
