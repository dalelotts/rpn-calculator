package com.dalelotts.rpn;

import com.dalelotts.rpn.testduplicates.InputStreamFake;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

public class StreamTokenizerTest {

    private void verifyInput(final String[] expectedTokens,
                             final StreamTokenizer input) {

        Assert.assertTrue(input.tokenAvailable());
        for (final String token : expectedTokens) {
            Assert.assertEquals(token, input.nextToken());
        }
        Assert.assertFalse(input.tokenAvailable());
    }

    @Test
    public final void constructor_FakeStreamInput() {
        final InputStream     is    = new InputStreamFake("12 5 9");
        final StreamTokenizer input = new StreamTokenizer(is);

        final String[] expectedTokens = {"12", "5", "9"};

        verifyInput(expectedTokens, input);
    }

    @Test
    public final void nextToken_mixedOperandOperatorWhitespace() {
        final InputStream     is    = new InputStreamFake("\t12 \n\t5\n9 + * -10 /");
        final StreamTokenizer input = new StreamTokenizer(is);

        final String[] expectedTokens = {"12", "5", "9", "+", "*", "-10", "/"};

        verifyInput(expectedTokens, input);
    }

    @Test
    public final void endOfInput_tokenAvailableFalse() {
        final InputStream     is    = new InputStreamFake("3 5");
        final StreamTokenizer input = new StreamTokenizer(is);

        final String[] expectedTokens = {"3", "5"};

        verifyInput(expectedTokens, input);

        Assert.assertFalse("empty input should not have available token",
                input.tokenAvailable());
    }

    @Test
    public final void endOfInput_nextTokenEmptyString() {
        final InputStream     is    = new InputStreamFake("3");
        final StreamTokenizer input = new StreamTokenizer(is);

        final String[] expectedTokens = {"3", ""};

        verifyInput(expectedTokens, input);
    }

}
