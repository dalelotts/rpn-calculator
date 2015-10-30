package com.dalelotts.rpn.token.operator;

import com.dalelotts.rpn.token.CalculatorToken;
import com.dalelotts.rpn.token.OperandToken;

import java.util.Stack;



public class SubtractionOperatorToken extends OperatorToken {

    protected SubtractionOperatorToken() {
        super("-");
    }

    @Override
    public CalculatorToken execute(Stack<CalculatorToken> stack) {

        if (stack.size() < 2) {
            throw new IllegalArgumentException(getSymbol() + " operation requires 2 operands");
        }

        Double y = ((OperandToken) stack.pop()).doubleValue();
        Double x = ((OperandToken) stack.pop()).doubleValue();

        return stack.push(new OperandToken(x - y));

    }
}
