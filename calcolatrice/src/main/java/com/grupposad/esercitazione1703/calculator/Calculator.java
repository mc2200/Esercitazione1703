package com.grupposad.esercitazione1703.calculator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.grupposad.esercitazione1703.calculator.operation.Operation;
import com.grupposad.esercitazione1703.calculator.operation.OperationFactory;

public class Calculator {
    private Double ans;
    public static Calculator shared = new Calculator();

    private Memory memory;

    private Calculator() {
        this.ans = 0.0;
        memory = new Memory();
    }

    private Double evaluate(Double a, Double b, String operation) {
        Operation op = OperationFactory.getOperation(operation);

        ans = op.calculate(a, b);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append(operation);
        stringBuilder.append(b);
        writeToMemory(stringBuilder.toString());

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

    public void setANS(Double newANS) {
        ans = newANS;
    }

    public Double ANS() {
        return ans;
    }

    public void clear() {
        ans = 0.0;
    }

    public List<String> readMemory() {
        return memory.read();
    }

    public void clearMemory() {
        memory.clearAll();
    }

    public void writeToMemory(String element) {
        memory.write(element);
    }

    public Double evaluateExpression(String expressionStr) throws Exception {
        Expression expression = new Expression(expressionStr);
        
        List<Double> values = new ArrayList<>();
        List<Operation> operations = new ArrayList<>();
    
        values.add(expression.nextReal());
    
        while (expression.hasNext()) {
            // Se è una parentesi chiusa, termina la valutazione corrente
            if (expression.get(expression.getPosition()) == ')') {
                break;
            }
    
            Operation operation = expression.nextOperation();
            Double nextValue = expression.nextReal();
    
            // Gestione priorità delle operazioni
            if (operation.getSymbol().equals("*") || operation.getSymbol().equals("/") || operation.getSymbol().equals(":")) {
                Double prevValue = values.remove(values.size() - 1);
                nextValue = operation.calculate(prevValue, nextValue);
                values.add(nextValue); // Aggiunge il risultato combinato
            } else {
                operations.add(operation);
                values.add(nextValue);
            }
        }
    
        // Esegue le somme e sottrazioni rimaste
        Double result = values.get(0);
        for (int i = 0; i < operations.size(); i++) {
            result = operations.get(i).calculate(result, values.get(i + 1));
        }
    
        return result;
    }

    public class Memory {
        private List<String> operations;

        public Memory() {
            this.operations = new LinkedList<>();
        }

        public List<String> read() {
            return operations;
        }

        public void write(String element) {
            operations.add(element);
        }

        public void clearAll() {
            operations.clear();
        }
    }
}    
