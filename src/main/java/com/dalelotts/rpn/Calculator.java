/* See the file "LICENSE" for the full license governing this code. */

package com.dalelotts.rpn;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Implementation of a Reverse Polish Notation calculator.
 *
 * @author Dale "Ducky" Lotts
 * @since 10/27/15.
 */

final class Calculator {


    private static final Pattern       DOUBLE_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");
    private final        Stack<Double> operandStack   = new Stack<>();
    private final PrintStream printStream;
    private final Scanner     scanner;

    Calculator(final Scanner scanner, final PrintStream printStream) {

        if (scanner == null) {
            throw new IllegalArgumentException("Null:scanner");
        }
        if (printStream == null) {
            throw new IllegalArgumentException("Null:printStream");
        }

        this.scanner = scanner;
        this.printStream = printStream;
    }

    private static boolean isOperand(final String testNumber) {
        return DOUBLE_PATTERN.matcher(testNumber).matches();
    }

    public void run() {

        printStream.println("Please enter values followed by operation symbols:");
        printStream.println("(Press CTRL+Z to end the program):");

        while (scanner.hasNext()) {
            final String tokenString = scanner.next();
            if (Operator.isOperator(tokenString)) {
                if (operandStack.size() < 2) {
                    printStream.println("Two operands are required");
                } else {
                    final double   operandTwo = operandStack.pop();
                    final double   operandOne = operandStack.pop();
                    final Operator operator   = Operator.fromString(tokenString);
                    final double   result     = operator.compute(operandOne, operandTwo);
                    operandStack.push(result);
                }
            } else if (isOperand(tokenString)) {
                operandStack.push(Double.parseDouble(tokenString));
            }
            // ToString on the following line to make the test verifications easier to write.
            // Don't do this in real life!
            printStream.println(operandStack.toString());
        }
    }
}
