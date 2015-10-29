package com.dalelotts.rpn;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Dale "Ducky" Lotts
 * @since 10/27/15.
 */

public class CalculatorTest {

    private Calculator calculator;

    @Test
    public void runShouldDoTheRightThing() {
        // Given
        calculator = new Calculator();

        // When
        calculator.run();

        // Then
        // How can we make sure the calculator did the right thing?
        assertThat("actual", equalTo("expected"));
    }
}
