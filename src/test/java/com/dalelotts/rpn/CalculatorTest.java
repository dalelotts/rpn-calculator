package com.dalelotts.rpn;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * @author Dale "Ducky" Lotts
 * @since 10/27/15.
 */

@SuppressWarnings("PMD.NonStaticInitializer")
public class CalculatorTest {

    @Tested
    private Calculator calculator;

    @Injectable
    private Scanner scanner;

    @Injectable
    private PrintStream outputStream;


    @Test(expected = IllegalArgumentException.class)  // Then
    public void constructorRequiresPrintStream() {

        // Given
        // Nothing to do

        // When
        new Calculator(scanner, null);

        // Then
        // Cannot reach this are because an exception is expected.
    }


    @Test(expected = IllegalArgumentException.class)   // Then
    public void constructorRequiresScanner() {

        // Given
        // Nothing to do

        // When
        new Calculator(null, outputStream);

        // Then
        // Cannot reach this are because an exception is expected.
    }

    @Test
    public void runAddsThreeOperands() throws Exception {
        // Given
        new Expectations() {{
            scanner.hasNext();
            returns(true, true, true, true, true, false);

            scanner.next();
            returns("5", "7", "+", "8", "+");
        }};

        // When
        calculator.run();

        // Then
        new Verifications() {{
            outputStream.println("[5.0]");
            outputStream.println("[5.0, 7.0]");
            outputStream.println("[12.0]");
            outputStream.println("[12.0, 8.0]");
            outputStream.println("[20.0]");
        }};
    }

    @Test
    public void runAddsTwoOperands() throws Exception {
        // Given
        new Expectations() {{
            scanner.hasNext();
            returns(true, true, true, false);

            scanner.next();
            returns("5", "7", "+");
        }};

        // When
        calculator.run();

        // Then
        new Verifications() {{
            outputStream.println("[5.0]");
            outputStream.println("[5.0, 7.0]");
            outputStream.println("[12.0]");
        }};
    }

    @Test
    public void runDivideByZeroIgnored() throws Exception {
        // Given
        new Expectations() {{
            scanner.hasNext();
            returns(true, true, true, false);

            scanner.next();
            returns("42", "0", "/");
        }};

        // When
        calculator.run();

        // Then
        new Verifications() {{
            outputStream.println("[42.0]");
            outputStream.println("[42.0, 0.0]");
            outputStream.println("[42.0]");
        }};
    }

    @Test
    public void runDivideByZeroInMiddleOfExpressionIsIgnored() throws Exception {
        // Given
        new Expectations() {{
            scanner.hasNext();
            returns(true, true, true, true, true, false);

            scanner.next();
            returns("42", "0", "/", "14", "-");
        }};

        // When
        calculator.run();

        // Then
        new Verifications() {{
            outputStream.println("[42.0]");
            outputStream.println("[42.0, 0.0]");
            outputStream.println("[42.0]");
            outputStream.println("[42.0, 14.0]");
            outputStream.println("[28.0]");
        }};
    }

    @Test
    public void runDivideThreeOperands() throws Exception {
        // Given
        new Expectations() {{
            scanner.hasNext();
            returns(true, true, true, true, true, false);

            scanner.next();
            returns("3", "1", "/", "76.32197", "/");
        }};

        // When
        calculator.run();

        // Then
        new Verifications() {{
            outputStream.println("[3.0]");
            outputStream.println("[3.0, 1.0]");
            outputStream.println("[3.0]");
            outputStream.println("[3.0, 76.32197]");
            outputStream.println("[0.03930716148967329]");
        }};
    }

    @Test
    public void runDivideTwoOperands() throws Exception {
        // Given
        new Expectations() {{
            scanner.hasNext();
            returns(true, true, true, false);

            scanner.next();
            returns("3", "1", "/");
        }};

        // When
        calculator.run();

        // Then
        new Verifications() {{
            outputStream.println("[3.0]");
            outputStream.println("[3.0, 1.0]");
            outputStream.println("[3.0]");
        }};
    }

    @Test
    public void runMultiplyThreeOperands() throws Exception {
        // Given
        new Expectations() {{
            scanner.hasNext();
            returns(true, true, true, true, true, false);

            scanner.next();
            returns("9", "3.1415926", "*", "42.2", "*");
        }};

        // When
        calculator.run();

        // Then
        new Verifications() {{
            outputStream.println("[9.0]");
            outputStream.println("[9.0, 3.1415926]");
            outputStream.println("[28.2743334]");
            outputStream.println("[28.2743334, 42.2]");
            outputStream.println("[1193.17686948]");
        }};
    }

    @Test
    public void runMultiplyTwoOperands() throws Exception {
        // Given
        new Expectations() {{
            scanner.hasNext();
            returns(true, true, true, false);

            scanner.next();
            returns("9", "3.1415926", "*");
        }};

        // When
        calculator.run();

        // Then
        new Verifications() {{
            outputStream.println("[9.0]");
            outputStream.println("[9.0, 3.1415926]");
            outputStream.println("[28.2743334]");
        }};
    }

    @Test
    public void runNonNumericOrOperatorInputIsIgnored() throws Exception {
        // Given
        new Expectations() {{
            scanner.hasNext();
            returns(true, true, true, false);

            scanner.next();
            returns("/9", "A", "-");
        }};


        // When
        calculator.run();

        // Then
        new Verifications() {{
            outputStream.println("[]");
            outputStream.println("[]");
            outputStream.println("Two operands are required");
        }};
    }

    @Test
    public void runOutputOperandsIfNoOperator() throws Exception {
        // Given
        new Expectations() {{
            scanner.hasNext();
            returns(true, false);

            scanner.next();
            returns("5");
        }};

        // When
        calculator.run();

        // Then
        new Verifications() {{
            outputStream.println("[5.0]");
        }};
    }

    @Test
    public void runOutputsInstructions() throws Exception {
        // Given
        new Expectations() {{
            scanner.hasNext();
            returns(true, false);

            scanner.next();
            returns("\n");
        }};

        // When
        calculator.run();

        // Then
        new Verifications() {{
            outputStream.println("Please enter values followed by operation symbols:");
            outputStream.println("(Press CTRL+Z to end the program):");
        }};
    }

    @Test
    public void runSubtractsThreeOperands() throws Exception {
        // Given
        new Expectations() {{
            scanner.hasNext();
            returns(true, true, true, true, true, false);

            scanner.next();
            returns("0.5", "7", "-", "-77", "-");
        }};

        // When
        calculator.run();

        // Then
        new Verifications() {{
            outputStream.println("[0.5]");
            outputStream.println("[0.5, 7.0]");
            outputStream.println("[-6.5]");
            outputStream.println("[-6.5, -77.0]");
            outputStream.println("[70.5]");
        }};
    }

    @Test
    public void runSubtractsTwoOperands() throws Exception {
        // Given
        new Expectations() {{
            scanner.hasNext();
            returns(true, true, true, false);

            scanner.next();
            returns("0.5", "7", "-");
        }};

        // When
        calculator.run();

        // Then
        new Verifications() {{
            outputStream.println("[0.5]");
            outputStream.println("[0.5, 7.0]");
            outputStream.println("[-6.5]");
        }};
    }

    @Test
    public void runWithNoOperandLogsError() throws Exception {
        // Given
        new Expectations() {{
            scanner.hasNext();
            returns(true, false);

            scanner.next();
            returns("*", "7", "-");
        }};

        // When
        calculator.run();

        // Then
        new Verifications() {{
            outputStream.println("Two operands are required");
            outputStream.println("[]");
        }};
    }
}
