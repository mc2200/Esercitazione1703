package com.grupposad.esercitazione1703.calculator.operation;

public class LogOperation extends Operation {

    @Override
    public Double calculate(Double a, Double b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Errore: Argomento e base del logaritmo non possono essere nulli.");
        }

        if (a <= 0) {
            throw new ArithmeticException("Errore: L'argomento del logaritmo deve essere positivo.");
        }

        if (b <= 0 || b == 1) {
            throw new ArithmeticException("Errore: La base del logaritmo deve essere positiva e diversa da 1.");
        }

        return Math.log(a) / Math.log(b);
    }

    @Override
    public String getSymbol() {
        return "log";
    }
}
