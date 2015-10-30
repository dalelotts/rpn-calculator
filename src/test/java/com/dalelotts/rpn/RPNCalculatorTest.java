package com.dalelotts.rpn;

import com.dalelotts.rpn.testduplicates.PrintStreamFake;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RPNCalculatorTest {

    private static final String NEW_LINE = System.getProperty("line.separator");

    private PrintStreamFake fakeOutput;
    private RPNCalculator   calc;

    @Before
    public void setUp() {
        fakeOutput = new PrintStreamFake();
        calc = new RPNCalculator(fakeOutput);
    }

    private void verifyOutput(final String[] expectedOutput) {
        final String[] consoleOutput = fakeOutput.GetStrings();

        Assert.assertEquals("output line count", expectedOutput.length,
                consoleOutput.length);
        for (int i = 0; i < expectedOutput.length; i++) {
            Assert.assertEquals(expectedOutput[i], consoleOutput[i]);
        }
    }

    @Test
    public final void singlePrintlnWithEmbeddedCRLF_CorrectOutputStrings() {
        final String[] expectedOutput = { "Hello World",
                "Today is a great day to code." };

        calc.println(expectedOutput[0] + NEW_LINE + expectedOutput[1]);

        verifyOutput(expectedOutput);
    }

    @Test
    public final void multiplePrintln_CorrectOutputStrings() {
        final String[] expectedOutput = { "Hello World",
                "Today is a great day to code." };

        calc.println(expectedOutput[0]);
        calc.println(expectedOutput[1]);

        verifyOutput(expectedOutput);
    }

}
