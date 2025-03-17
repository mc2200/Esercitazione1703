package com.grupposad.esercitazione1703.calculator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorUI {
    private static String intro = "\n ### Welcome to this Calculator ### " + 
                                    "\n ### Main operations are ### " + 
                                    "\n 1. Basic operation (i.e. 5+5) " + 
                                    "\n 2. Chained operations (i.e. ans-3) " + 
                                    "\n 3. Scientific operations (i.e. sin, log, exp) " + 
                                    "\n 4. Clear ANS " + 
                                    "\n 5. Read Memory (See last operations)" + 
                                    "\n 7. To print this message again " + 
                                    "\n 8. To exit " + 
                                    "\n ### Select an input ### \n";

    private Calculator calculator = Calculator.shared;

    public void commandLineTool() {
        boolean exit = false;
        while (!exit) {
            System.out.println(intro + 
                                "### ANS: " + calculator.ANS());

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    o1();
                    break;
                case "2":
                    o2();
                    break;
                case "3":
                    o3();
                    break;
                case "4":
                    o4();
                    break;
                case "5":
                    o5();
                    break;
                case "7":
                    continue;
                case "8":
                    exit = true;
                    break;
                default:
                    exit = true;
                    break;
            }
        }

    }

    public void o1() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n ### Digit the first number ### \n");
        String first = scanner.nextLine();
        Double a = Double.valueOf(first);

        System.out.println("\n ### Digit the operation (+, -, /, :, *) ### \n");
        String operation = scanner.nextLine();

        System.out.println("\n ### Digit the second number ### \n");
        String second = scanner.nextLine();
        Double b = Double.valueOf(second);

        System.out.println("\n Result: " + calculator.basicEvaluation(a, b, operation));
    }

    public void o2() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n ### Digit the operation (+, -, /, :, *, sin, cos, tan, log, exp) ### \n");
        String operation = scanner.nextLine();

        System.out.println("\n ### Digit the second number ### \n");
        String second = scanner.nextLine();
        Double b = Double.valueOf(second);

        System.out.println("\n Result: " + calculator.chainedEvaluation(b, operation));
    }

    public void o3() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n ### Digit the operation (sin, cos, tan, log, exp) ### \n");
        String operation = scanner.nextLine();

        Double a = null, b = null;
        switch (operation) {
            case "sin", "cos", "tan":
                System.out.println("\n ### Digit the degrees ### \n");
                String degrees = scanner.nextLine();
                a = Double.valueOf(degrees);

                break;
            case "log", "exp":
                System.out.println("\n ### Digit the argument ### \n");
                String argument = scanner.nextLine();
                a = Double.valueOf(argument);

                System.out.println("\n ### Digit the base ### \n");
                String base = scanner.nextLine();
                b = Double.valueOf(base);

                break;
            default:
                break;
        }

        System.out.println("\n Result: " + calculator.basicEvaluation(a, b, operation));
    }

    public void o4() {
        calculator.clear();
    }

    public void o5() {
        System.out.println("\n ### LAST OPERATIONS ###");
        int count = 1;
        List<String> operations = calculator.readMemory();

        for (String op : operations) {
            System.out.println("\n" + count + "\t" + op);
            count += 1;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n ### Select an operation to get the result as new ANS ### \n");
        String num = scanner.nextLine();

        int n = Integer.parseInt(num);

        String operation = operations.get(n);
        
        Double lastResult = Double.parseDouble(operation.split("=")[1]);

        calculator.setANS(lastResult);
    }

}
