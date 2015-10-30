package com.dalelotts.rpn.token;

public class OperandToken extends CalculatorToken {

    private static String formatOperand(String sym) {

        Double value = new Double(sym);
        String str   = value.toString();
        if (str.endsWith(".0")) {
            return str.substring(0, str.length() - 2);
        }
        return str;
    }


    public OperandToken(String symbol) {

        super(formatOperand(symbol));
    }


    public OperandToken(Double value) {

        super(formatOperand(value.toString()));
    }


    @Override
    public final boolean isOperator() {

        return false;
    }


    public double doubleValue() {

        return new Double(getSymbol());
    }

}
