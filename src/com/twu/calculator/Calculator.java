package com.twu.calculator;

public class Calculator {

    private double result;

    public double doOperation(String operation, double operand) {
        switch (operation) {
            case "add":
                result += operand;
                break;
            case "subtract":
                result -= operand;
                break;
            case "multiply":
                result *= operand;
                break;
            case "divide":
                result /= operand;
                break;
            case "abs":
                result = Math.abs(result);
                break;
            case "neg":
                result = -result;
                break;
            case "cancel":
                result = 0;
                break;
            case "exit":
                System.exit(0);
        }
        return result;
    }
}
