package com.grupposad.esercitazione1703.calculator;

import com.grupposad.esercitazione1703.calculator.operation.Operation;
import com.grupposad.esercitazione1703.calculator.operation.OperationFactory;

public class Calculator {
    private Double ans;
    public static Calculator shared = new Calculator();

    private Calculator() {
        this.ans = 0.0;
    }

    private Double evaluate(Double a, Double b, String operation) {
        Operation op = OperationFactory.getOperation(operation);

        ans = op.calculate(a, b);

        return ans;
    }

    public Double basicEvaluation(Double a, Double b, String operation) {
        return evaluate(a, b, operation);
    }

    public Double chainedEvaluation(Double b, String operation) {
        return evaluate(ans, b, operation);
    }

    public Double scientificEvaluation(Double a, Double b, String operation) {
        return evaluate(a, b, operation);
    }

    public Double ANS() {
        return ans;
    }

    public void clear() {
        ans = 0.0;
    }
}    
