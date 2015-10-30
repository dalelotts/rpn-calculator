package com.dalelotts.rpn.testduplicates;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class PrintStreamFake extends PrintStream {

    // When splitting strings be sure to be operating system independent.
    private static final String NEW_LINE = System.getProperty("line.separator");

    public PrintStreamFake() {

        super(new ByteArrayOutputStream(), true);
    }


    public String[] GetStrings() {

        return out.toString().split(NEW_LINE);
    }

}
