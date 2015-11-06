package com.dalelotts.rpn;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Dale "Ducky" Lotts
 * @since 11/5/15.
 */
public class OperatorTest {

    private static final List<String> OPERATORS = Arrays.asList("+", "-", "*", "/");


    @Test
    public void toStringEqualsFromString() throws Exception {
        for (final String theOperator : OPERATORS) {
            final Operator operator = Operator.fromString(theOperator);
            assertThat(theOperator, is(operator.toString()));
        }
    }


    @Test(expected = IllegalArgumentException.class)
    public void fromStringThrowsExceptionForNonOperator() {
        Operator.fromString("x");
    }

    @Test
    public void isOperatorReturnsTrueForAllOperators() throws Exception {
        for (final String operator : OPERATORS) {
            assertThat(Operator.isOperator(operator), is(true));
        }
    }

    @Test
    public void isOperatorReturnsFalseForNonOperators() throws Exception {
        final String[] nonOperators = {"x", "\\", "\n", "\t", "--", "~"};
        for (final String operator : nonOperators) {
            assertThat(Operator.isOperator(operator), is(false));
        }
    }


    @Test
    public void addComputeReturnsSum() throws Exception {
        assertThat(Operator.ADD.compute(0.1, 1.9), is(2.0));
    }


    @Test
    public void subtractComputeReturnsDifference() throws Exception {
        assertThat(Operator.SUBTRACT.compute(1, 0.9), is(0.09999999999999998)); // Expected floating point math error
    }

    @Test
    public void multiplyComputeReturnsProduct() throws Exception {
        assertThat(Operator.MULTIPLY.compute(13, 9), is(117.0));
    }

    @Test
    public void divideComputeReturnsQuotient() throws Exception {
        assertThat(Operator.DIVIDE.compute(45, 9), is(5.0));
    }
}
