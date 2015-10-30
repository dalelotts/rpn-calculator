package com.dalelotts.rpn.token;

import com.dalelotts.rpn.token.operator.OperatorToken;
import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class DivisionOperatorTokenTest {
    @Test
    public final void isValidOperatorSymbol() {
        assertTrue(OperatorToken.isValidOperatorSymbol("/"));
    }

    @Test
    public final void createDivisionOperatorToken_Success() {
        final String operatorSymbol = "/";
        final OperatorToken operator = OperatorToken
                .createOperatorToken(operatorSymbol);
        assertEquals(operatorSymbol, operator.toString());
    }

    @Test
    public final void divisionOperatorToken_CanDivideOperandsSuccessfully() {
        final OperatorToken          operator = OperatorToken.createOperatorToken("/");
        final Stack<CalculatorToken> stack    = new Stack<CalculatorToken>();
        stack.push(new OperandToken(16.5));
        stack.push(new OperandToken(2.0));
        final OperandToken expected = new OperandToken(8.25);

        assertEquals(expected, operator.execute(stack));
    }
}
