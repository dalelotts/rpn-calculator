/* See the file "LICENSE" for the full license governing this code. */
package com.dalelotts.rpn;

import java.util.Scanner;

/**
 * Implementation of a Reverse Polish Notation calculator.
 *
 * @author Dale "Ducky" Lotts
 * @since 10/27/15.
 */

final class Calculator {

	public void run() {

		final Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter values followed by operation symbols:");
		System.out.println("(Press CTRL+Z to end the program):");

		while (scanner.hasNext()) {
			final String tokenString = scanner.next();
			System.out.println(tokenString);
		}
	}
}
