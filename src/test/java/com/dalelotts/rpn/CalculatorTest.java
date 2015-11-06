package com.dalelotts.rpn;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @author Dale "Ducky" Lotts
 * @since 10/27/15.
 */

public class CalculatorTest {

    // When splitting strings be sure to be operating system independent.
    private static final String NEW_LINE = System.getProperty("line.separator");

    private Calculator   calculator;
    private OutputStream outputStream;


    @Before
    public void before() {

        outputStream = new ByteArrayOutputStream();
    }


    @Test(expected = IllegalArgumentException.class)  // Then
    public void constructorRequiresPrintStream() {

        // Given
        final Scanner scanner = new Scanner(System.in);

        // When
        new Calculator(scanner, null);

        // Then
        // Cannot reach this are because an exception is expected.
    }


    @Test(expected = IllegalArgumentException.class)   // Then
    public void constructorRequiresScanner() {

        // Given
        final PrintStream printStream = new PrintStream(System.out);

        // When
        new Calculator(null, printStream);

        // Then
        // Cannot reach this are because an exception is expected.
    }

    @Test
    public void runAddsThreeOperands() throws Exception {
        // Given
        try (final InputStream inputStream = IOUtils.toInputStream("5 7 + 8 +\n", "UTF-8")) {
            calculator = new Calculator(new Scanner(inputStream), new PrintStream(outputStream));

            // When
            calculator.run();

            // Then
            final String[] strings = outputStream.toString().split(NEW_LINE);

            Assert.assertThat(strings[2], equalTo("[5.0]"));
            Assert.assertThat(strings[3], equalTo("[5.0, 7.0]"));
            Assert.assertThat(strings[4], equalTo("[12.0]"));
            Assert.assertThat(strings[5], equalTo("[12.0, 8.0]"));
            Assert.assertThat(strings[6], equalTo("[20.0]"));
        }
    }

    @Test
    public void runAddsTwoOperands() throws Exception {
        // Given
        try (final InputStream inputStream = IOUtils.toInputStream("5 7 +\n", "UTF-8")) {
            calculator = new Calculator(new Scanner(inputStream), new PrintStream(outputStream));

            // When
            calculator.run();

            // Then
            final String[] strings = outputStream.toString().split(NEW_LINE);

            Assert.assertThat(strings[2], equalTo("[5.0]"));
            Assert.assertThat(strings[3], equalTo("[5.0, 7.0]"));
            Assert.assertThat(strings[4], equalTo("[12.0]"));
        }
    }

    @Test
    public void runDivideByZeroIgnored() throws Exception {
        // Given
        try (final InputStream inputStream = IOUtils.toInputStream("42 0 /\n", "UTF-8")) {
            calculator = new Calculator(new Scanner(inputStream), new PrintStream(outputStream));

            // When
            calculator.run();

            // Then
            final String[] strings = outputStream.toString().split(NEW_LINE);

            Assert.assertThat(strings[2], equalTo("[42.0]"));
            Assert.assertThat(strings[3], equalTo("[42.0, 0.0]"));
            Assert.assertThat(strings[4], equalTo("[42.0]"));
        }
    }

    @Test
    public void runDivideByZeroInMiddleOfExpressionIsIgnored() throws Exception {
        // Given
        try (final InputStream inputStream = IOUtils.toInputStream("42 0 / 14 -\n", "UTF-8")) {
            calculator = new Calculator(new Scanner(inputStream), new PrintStream(outputStream));

            // When
            calculator.run();

            // Then
            final String[] strings = outputStream.toString().split(NEW_LINE);

            Assert.assertThat(strings[2], equalTo("[42.0]"));
            Assert.assertThat(strings[3], equalTo("[42.0, 0.0]"));
            Assert.assertThat(strings[4], equalTo("[42.0]"));
            Assert.assertThat(strings[5], equalTo("[42.0, 14.0]"));
            Assert.assertThat(strings[6], equalTo("[28.0]"));
        }
    }

    @Test
    public void runDivideThreeOperands() throws Exception {
        // Given
        try (final InputStream inputStream = IOUtils.toInputStream("3 1 / 76.32197 /\n", "UTF-8")) {
            calculator = new Calculator(new Scanner(inputStream), new PrintStream(outputStream));

            // When
            calculator.run();

            // Then
            final String[] strings = outputStream.toString().split(NEW_LINE);

            Assert.assertThat(strings[2], equalTo("[3.0]"));
            Assert.assertThat(strings[3], equalTo("[3.0, 1.0]"));
            Assert.assertThat(strings[4], equalTo("[3.0]"));
            Assert.assertThat(strings[5], equalTo("[3.0, 76.32197]"));
            Assert.assertThat(strings[6], equalTo("[0.03930716148967329]"));
        }
    }

    @Test
    public void runDivideTwoOperands() throws Exception {
        // Given
        try (final InputStream inputStream = IOUtils.toInputStream("3 1 /\n", "UTF-8")) {
            calculator = new Calculator(new Scanner(inputStream), new PrintStream(outputStream));

            // When
            calculator.run();

            // Then
            final String[] strings = outputStream.toString().split(NEW_LINE);

            Assert.assertThat(strings[2], equalTo("[3.0]"));
            Assert.assertThat(strings[3], equalTo("[3.0, 1.0]"));
            Assert.assertThat(strings[4], equalTo("[3.0]"));
        }
    }

    @Test
    public void runMultiplyThreeOperands() throws Exception {
        // Given
        try (final InputStream inputStream = IOUtils.toInputStream("9 3.1415926 * 42.2 *\n", "UTF-8")) {
            calculator = new Calculator(new Scanner(inputStream), new PrintStream(outputStream));

            // When
            calculator.run();

            // Then
            final String[] strings = outputStream.toString().split(NEW_LINE);

            Assert.assertThat(strings[2], equalTo("[9.0]"));
            Assert.assertThat(strings[3], equalTo("[9.0, 3.1415926]"));
            Assert.assertThat(strings[4], equalTo("[28.2743334]"));
            Assert.assertThat(strings[5], equalTo("[28.2743334, 42.2]"));
            Assert.assertThat(strings[6], equalTo("[1193.17686948]"));
        }
    }

    @Test
    public void runMultiplyTwoOperands() throws Exception {
        // Given
        try (final InputStream inputStream = IOUtils.toInputStream("9 3.1415926 *\n", "UTF-8")) {
            calculator = new Calculator(new Scanner(inputStream), new PrintStream(outputStream));

            // When
            calculator.run();

            // Then
            final String[] strings = outputStream.toString().split(NEW_LINE);

            Assert.assertThat(strings[2], equalTo("[9.0]"));
            Assert.assertThat(strings[3], equalTo("[9.0, 3.1415926]"));
            Assert.assertThat(strings[4], equalTo("[28.2743334]"));
        }
    }

    @Test
    public void runNonNumericOrOperatorInputIsIgnored() throws Exception {
        // Given
        try (final InputStream inputStream = IOUtils.toInputStream("/9 A -\n", "UTF-8")) {
            calculator = new Calculator(new Scanner(inputStream), new PrintStream(outputStream));

            // When
            calculator.run();

            // Then
            final String[] strings = outputStream.toString().split(NEW_LINE);

            Assert.assertThat(strings[2], equalTo("[]"));
            Assert.assertThat(strings[3], equalTo("[]"));
            Assert.assertThat(strings[4], equalTo("Two operands are required"));
        }
    }

    @Test
    public void runOutputOperandsIfNoOperator() throws Exception {
        // Given
        try (final InputStream inputStream = IOUtils.toInputStream("5\n", "UTF-8")) {
            calculator = new Calculator(new Scanner(inputStream), new PrintStream(outputStream));

            // When
            calculator.run();

            // Then
            final String[] strings = outputStream.toString().split(NEW_LINE);

            Assert.assertThat(strings[2], equalTo("[5.0]"));
        }
    }

    @Test
    public void runOutputsInstructions() throws Exception {
        // Given
        try (final InputStream inputStream = IOUtils.toInputStream("\n", "UTF-8")) {
            calculator = new Calculator(new Scanner(inputStream), new PrintStream(outputStream));

            // When
            calculator.run();

            // Then
            final String[] strings = outputStream.toString().split(NEW_LINE);

            Assert.assertThat(strings.length, equalTo(2));
            Assert.assertThat(strings[0], equalTo("Please enter values followed by operation symbols:"));
            Assert.assertThat(strings[1], equalTo("(Press CTRL+Z to end the program):"));
        }
    }

    @Test
    public void runSubtractsThreeOperands() throws Exception {
        // Given
        try (final InputStream inputStream = IOUtils.toInputStream("0.5 7 - -77 -\n", "UTF-8")) {
            calculator = new Calculator(new Scanner(inputStream), new PrintStream(outputStream));

            // When
            calculator.run();

            // Then
            final String[] strings = outputStream.toString().split(NEW_LINE);

            Assert.assertThat(strings[2], equalTo("[0.5]"));
            Assert.assertThat(strings[3], equalTo("[0.5, 7.0]"));
            Assert.assertThat(strings[4], equalTo("[-6.5]"));
            Assert.assertThat(strings[5], equalTo("[-6.5, -77.0]"));
            Assert.assertThat(strings[6], equalTo("[70.5]"));
        }
    }

    @Test
    public void runSubtractsTwoOperands() throws Exception {
        // Given
        try (final InputStream inputStream = IOUtils.toInputStream("0.5 7 -\n", "UTF-8")) {
            calculator = new Calculator(new Scanner(inputStream), new PrintStream(outputStream));

            // When
            calculator.run();

            // Then
            final String[] strings = outputStream.toString().split(NEW_LINE);

            Assert.assertThat(strings[2], equalTo("[0.5]"));
            Assert.assertThat(strings[3], equalTo("[0.5, 7.0]"));
            Assert.assertThat(strings[4], equalTo("[-6.5]"));
        }
    }

    @Test
    public void runWithNoOperandLogsError() throws Exception {
        // Given
        try (final InputStream inputStream = IOUtils.toInputStream("*\n", "UTF-8")) {
            calculator = new Calculator(new Scanner(inputStream), new PrintStream(outputStream));

            // When
            calculator.run();

            // Then
            final String[] strings = outputStream.toString().split(NEW_LINE);

            Assert.assertThat(strings[2], equalTo("Two operands are required"));
            Assert.assertThat(strings[3], equalTo("[]"));
        }
    }
}
