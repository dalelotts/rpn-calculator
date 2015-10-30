package com.dalelotts.rpn.token;

import com.dalelotts.rpn.token.operator.OperatorToken;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AdditionOperatorTokenTest {
    @Test
    public final void createAdditionOperatorToken_Success() {
        final String operatorSymbol = "+";
        final OperatorToken operator = OperatorToken
                .createOperatorToken(operatorSymbol);
        assertEquals(operatorSymbol, operator.toString());
    }

    @Test
    public final void executeAdditionOperatorSymbol_GoodSum() {
        final OperatorToken          operator = OperatorToken.createOperatorToken("+");
        final Stack<CalculatorToken> stack    = new Stack<CalculatorToken>();
        stack.push(new OperandToken("5"));
        stack.push(new OperandToken("3"));

        assertEquals(new OperandToken("8"), operator.execute(stack));
        assertEquals(1, stack.size());
    }

    @Test
    public final void isValidOperatorSymbol() {
        assertTrue(OperatorToken.isValidOperatorSymbol("+"));
    }

    @Test
    public final void additionOperatorToken_CanAddOperandsSuccessfully() {
        final OperatorToken          operator = OperatorToken.createOperatorToken("+");
        final Stack<CalculatorToken> stack    = new Stack<CalculatorToken>();
        stack.push(new OperandToken(3.5));
        stack.push(new OperandToken(2.75));
        final OperandToken expected = new OperandToken(6.25);

        assertEquals(expected, operator.execute(stack));
    }
}
