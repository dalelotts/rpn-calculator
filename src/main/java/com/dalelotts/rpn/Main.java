/* See the file "LICENSE" for the full license governing this code. */
package com.dalelotts.rpn;

import java.util.Scanner;

/**
 * Main class and entry point for the RPN Calculator.
 *
 * @author Dale "Ducky" Lotts
 * @since 10/28/15.
 */

public final class Main {

    private Main() {

    }


    public static void main(final String... args) {
        new Calculator(new Scanner(System.in), System.out).run();
    }
}
