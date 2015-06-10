package com.twu.calculator;

public class Calculator {

    private double result;

    public double processCommand(String command) {
        if (command.equals("cancel"))
            return (result = 0);
        if (command.equals("exit"))
            System.exit(0);
        String[] splitCommand = command.split(" ");
        String operation = splitCommand[0];
        double operand = Double.parseDouble(splitCommand[1]);
        return doOperation(operation, operand);
    }

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
        }
        return result;
    }
}
