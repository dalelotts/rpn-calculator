/* See the file "LICENSE" for the full license governing this code. */

package com.dalelotts.rpn;

/**
 * @author Dale "Ducky" Lotts
 * @since 10/29/15.
 */
enum Operator {

    ADD("+") {
        @Override
        double compute(final double operandOne, final double operandTwo) {
            return operandOne + operandTwo;
        }
    },
    DIVIDE("/") {
        @Override
        double compute(final double operandOne, final double operandTwo) {
            if (operandTwo == 0d) {
                return operandOne;
            } else {
                return operandOne / operandTwo;
            }
        }
    },
    MULTIPLY("*") {
        @Override
        double compute(final double operandOne, final double operandTwo) {
            return operandOne * operandTwo;
        }
    },
    SUBTRACT("-") {
        @Override
        double compute(final double operandOne, final double operandTwo) {
            return operandOne - operandTwo;
        }
    };


    private final String operator;

    Operator(final String operator) {
        this.operator = operator;
    }

    abstract double compute(final double operandOne, final double operandTwo);

    static Operator fromString(final String theOperator) {
        for (final Operator operator : Operator.values()) {
            if (theOperator.equals(operator.operator)) {
                return operator;
            }
        }
        throw new IllegalArgumentException("Not an operator: " + theOperator);
    }

    static boolean isOperator(final String testOperator) {
        for (final Operator operator : Operator.values()) {
            if (testOperator.equals(operator.operator)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return operator;
    }
}
