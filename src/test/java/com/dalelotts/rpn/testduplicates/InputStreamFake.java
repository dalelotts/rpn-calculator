package com.dalelotts.rpn.testduplicates;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.io.UnsupportedEncodingException;

public class InputStreamFake extends PushbackInputStream {

    private static final String UTF8 = "UTF-8";


    private static InputStream convertStringToInputStream(String input) {

        try {
            return new ByteArrayInputStream(input.getBytes(UTF8));
        } catch (UnsupportedEncodingException e) {
            return new ByteArrayInputStream(null);
        }

    }


    public InputStreamFake(String input) {

        super(convertStringToInputStream(input));
    }

}
