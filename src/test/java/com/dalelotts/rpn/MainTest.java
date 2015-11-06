package com.dalelotts.rpn;

import mockit.Mocked;
import mockit.Verifications;
import org.junit.Test;

/**
 * @author Dale "Ducky" Lotts
 * @since 10/28/15.
 */

@SuppressWarnings("PMD.NonStaticInitializer")
public class MainTest {

    @Mocked
    private Calculator calculator;

    @Test
    public void mainCallsCalculatorRun() {

        Main.main();

        new Verifications() {{
            calculator.run();
        }};
    }
}
