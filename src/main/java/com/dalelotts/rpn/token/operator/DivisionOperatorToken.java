package com.dalelotts.rpn.token.operator;

import com.dalelotts.rpn.token.CalculatorToken;
import com.dalelotts.rpn.token.OperandToken;

import java.util.Stack;



public class DivisionOperatorToken extends OperatorToken {

    protected DivisionOperatorToken() {
        super("/");
    }

    @Override
    public CalculatorToken execute(Stack<CalculatorToken> stack) {
        
        if (stack.size() < 2) {
            throw new IllegalArgumentException(getSymbol() + " operation requires 2 operands");
        } 

        Double y = ((OperandToken)stack.pop()).doubleValue();
        
        if (y.intValue() == 0) {
            throw new IllegalArgumentException("Cannot divide by 0!");
        }
        
        Double x = ((OperandToken)stack.pop()).doubleValue();

        return stack.push(new OperandToken(x / y));
        
    }
}
