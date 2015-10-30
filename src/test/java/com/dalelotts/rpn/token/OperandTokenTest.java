package com.dalelotts.rpn.token;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class OperandTokenTest {

    @Test
    public final void createTokenWithDoubleValue() {
        final Double       value  = 3.1415;
        final OperandToken number = new OperandToken(value);
        assertEquals("bad numeric value", value, number.doubleValue(), 0.001);
        assertEquals("bad numeric value", value.toString(), number.toString());
    }

    @Test
    public final void createTokenWithStringValue() {
        final String       value  = "3.1415";
        final OperandToken number = new OperandToken(value);
        assertEquals("bad string value", value, number.toString());
        assertEquals("bad numeric value", new Double(value),
                number.doubleValue(), 0.001);
    }

    @Test(expected = NumberFormatException.class)
    public final void createTokenWithBadStringValue_ThrowException() {
        final String value = "3.14.15";
        new OperandToken(value);
    }

    @Test(expected = NumberFormatException.class)
    public final void createTokenWithEmptyString_ThrowException() {
        new OperandToken("");
    }

    @Test
    public final void toString_returnsTokenSymbolAsString() {
        final CalculatorToken token = new OperandToken("5");
        assertEquals("5", token.toString());
    }

    @Test
    public final void isOperator_False() {
        final CalculatorToken token = new OperandToken("5");
        assertFalse(token.isOperator());
    }
}
