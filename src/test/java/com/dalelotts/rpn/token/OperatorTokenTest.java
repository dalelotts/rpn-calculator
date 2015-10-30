package com.dalelotts.rpn.token;

import com.dalelotts.rpn.token.operator.OperatorToken;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class OperatorTokenTest {

    @Test
    public final void isOperator_True() {
        final OperatorToken operator = OperatorToken.createOperatorToken("+");
        assertTrue(operator.isOperator());
    }

    @Test
    public final void toString_returnsTokenSymbolAsString() {
        final OperatorToken operator = OperatorToken.createOperatorToken("+");
        assertEquals("+", operator.toString());
    }
}
