package com.twu.calculator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldReturnZeroWhenZeroIsAddedAsInitialCommand() {
        Calculator calculator = new Calculator();

        double actualResult = calculator.doOperation("add", 0);

        assertThat(actualResult, is(0.0));
    }

    @Test
    public void shouldReturnCorrectValueWhenAValueIsAddedAsInitialCommand() {
        Calculator calculator = new Calculator();

        double actualResult = calculator.doOperation("add", 10);

        assertThat(actualResult, is(10.0));
    }

    @Test
    public void shouldReturnCorrectValueWhenTwoAddCommandAreGiven() {
        Calculator calculator = new Calculator();
        calculator.doOperation("add", 10);

        double actualResult = calculator.doOperation("add", 20);

        assertThat(actualResult, is(30.0));
    }

    @Test
    public void shouldReturnCorrectValueWhenFirstCommandIsAddAndSecondCommandIsSubtract() {
        Calculator calculator = new Calculator();
        calculator.doOperation("add", 30);

        double actualResult = calculator.doOperation("subtract", 20);

        assertThat(actualResult, is(10.0));
    }

    @Test
    public void shouldReturnCorrectValueWhenFirstCommandIsAddAndSecondCommandIsMultiply() {
        Calculator calculator = new Calculator();
        calculator.doOperation("add", 10);

        double actualResult = calculator.doOperation("multiply", 20);

        assertThat(actualResult, is(200.0));
    }

    @Test
    public void shouldReturnCorrectValueWhenFirstCommandIsAddAndSecondCommandIsDivide() {
        Calculator calculator = new Calculator();
        calculator.doOperation("add", 10);

        double actualResult = calculator.doOperation("divide", 2);

        assertThat(actualResult, is(5.0));
    }

    @Test
    public void shouldSetTheCalculatorStateToZeroWhenCancelCommandIsGiven() {
        Calculator calculator = new Calculator();
        calculator.doOperation("add", 10);

        double actualResult = calculator.doOperation("cancel", 0);

        assertThat(actualResult, is(0.0));
    }

    @Test
    public void shouldExitOutOfTheCalculatorAppWhenExitCommandIsGiven() {
        Calculator calculator = new Calculator();
        exit.expectSystemExitWithStatus(0);
        calculator.doOperation("exit", 0);
    }

    @Test
    public void shouldReturnAbsoluteValueOfResult() {
        Calculator calculator = new Calculator();
        calculator.doOperation("add", -10);

        double actualResult = calculator.doOperation("abs", 0);

        assertThat(actualResult, is(10.0));
    }
}
