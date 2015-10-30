package com.dalelotts.rpn.token.operator;

import com.dalelotts.rpn.token.CalculatorToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public abstract class OperatorToken extends CalculatorToken {

    private static final List<String> operatorSymbols = new ArrayList<String>(
            Arrays.asList(//
                    "+", //
                    "-", //
                    "*", //
                    "/" //
            ));

    public static boolean isValidOperatorSymbol(final String symbol) {
        return operatorSymbols.contains(symbol);
    }

    public OperatorToken(final String symbol) {
        super(symbol);
    }

    public abstract CalculatorToken execute(Stack<CalculatorToken> stack);

    @Override
    public final boolean isOperator() {
        return true;
    }

    public static OperatorToken createOperatorToken(final String operatorSymbol) {
        switch (operatorSymbol.charAt(0)) {
            case '+':
                return new AdditionOperatorToken();
            case '-':
                return new SubtractionOperatorToken();
            case '*':
                return new MultiplicationOperatorToken();
            case '/':
                return new DivisionOperatorToken();
        }
        throw new IllegalArgumentException("Unrecognized Operator Symbol");
    }
}
