/* See the file "LICENSE" for the full license governing this code. */
package com.dalelotts.rpn;

import org.apache.commons.io.IOUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * This test is for reference only, please do not write tests for java libraries.
 *
 * @author Dale "Ducky" Lotts
 * @since 10/30/15.
 */

public final class ScannerTest {

    private Scanner scanner;

    @Before
    public void before() {
        // Setup code that should run BEFORE each test goes here
        // In this example, no setup is needed.
    }

    @Test
    public void hasNextReturnsFalseForEmptyString() throws Exception {
        // Given
        try (final InputStream inputStream = IOUtils.toInputStream("", "UTF-8")) {
            scanner = new Scanner(inputStream);

            // When
            final boolean hasNext = scanner.hasNext();

            // Then
            assertThat(hasNext, is(false));
        }
    }

    @Test (expected = NoSuchElementException.class)  // Then
    public void nextThrowsExceptionForEmptyString() throws Exception {
        // Given
        try (final InputStream inputStream = IOUtils.toInputStream("", "UTF-8")) {
            scanner = new Scanner(inputStream);

            // When
            scanner.next(); // Expect this to throw an exception

            // Then
            // Will not reach this point.
            // (expected = NoSuchElementException.class) above
            // tells JUnit that this test should throw a NoSuchElementException.
        }
    }

    @After
    public void after () {
        // tear down  code that should be run AFTER each test goes here
        // In this example, no tear down is needed.
    }
}
