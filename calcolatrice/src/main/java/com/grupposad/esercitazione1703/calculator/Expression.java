package com.grupposad.esercitazione1703.calculator;

import com.grupposad.esercitazione1703.calculator.operation.Operation;
import com.grupposad.esercitazione1703.calculator.operation.OperationFactory;

public class Expression {
    private String expression;
    private int position;

    public Expression(String expression) throws Exception {
        if (!verify(expression)) {
            throw new Exception("Espressione non valida");
        }
        this.expression = expression.replaceAll("\\s+", ""); // Rimuove spazi
        this.position = 0;
    }

    static boolean verify(String expression) {
        // Verifica basilare (da migliorare)
        return expression.matches("[0-9+\\-*/().:]+");
    }

    public Operation nextOperation() {
        if (position >= expression.length()) {
            return null;
        }

        StringBuilder op = new StringBuilder();
        String operationStr = String.valueOf(expression.charAt(position));
        position += 1;
        return OperationFactory.getOperation(operationStr);
    }

    public boolean hasNext() {
        return position < expression.length();
    }

    /*public Double nextReal() {
        if (position >= expression.length()) {
            return null;
        }

        String realStr = String.valueOf(expression.charAt(position));
        position += 1;
        return Double.valueOf(realStr);
    }*/

    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == ':' || c == '(' || c == ')';
    }

    public char get(int position) {
        return expression.charAt(position);
    }

    public int getPosition() {
        return position;
    }

    public Double nextReal() {
        StringBuilder num = new StringBuilder();
    
        // Gestione del numero negativo (dopo un'operazione o all'inizio)
        if (position < expression.length() && get(position) == '-') {
            // Controlla se il meno è parte di un numero negativo
            if (position == 0 || isOperator(get(position - 1)) || get(position - 1) == '(') {
                num.append('-');
                position++;
            }
        }
    
        // Costruisce il numero finché non trova un operatore o la fine della stringa
        while (position < expression.length() && !isOperator(get(position))) {
            num.append(get(position));
            position++;
        }
    
        // Controlla se è stato trovato un numero valido
        if (num.length() == 0) {
            throw new IllegalArgumentException("Numero non valido nell'espressione");
        }
    
        return Double.valueOf(num.toString());
    }

}