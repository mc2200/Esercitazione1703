package com.grupposad.esercitazione1703.calculator.operation;

public class OperationFactory {
    public static Operation getOperation(String operationStr) {
        switch (operationStr) {
            case "+":
                return new SumOperation();
            case "-":
                return new SubOperation();
            case "/":
                return new DivideOperation();
            case ":":
                return new DivideOperation();
            case "*":
                return new MultiplyOperation();
            case "sin":
                return new SinOperation();
            case "cos":
                return new CosOperation();
            case "tan":
                return new TanOperation();
            case "log":
                return new LogOperation();
            case "exp":
                return new ExpOperation();
            default:
                break;
        }

        return null;
    }
}