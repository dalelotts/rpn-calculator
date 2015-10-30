package com.dalelotts.rpn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamTokenizer {

    private       BufferedReader inputStream = null;
    private final List<String>   input       = new ArrayList<String>();


    public StreamTokenizer() {

        inputStream = new BufferedReader(new InputStreamReader(System.in));
    }


    public StreamTokenizer(final InputStream streamInput) {

        inputStream = new BufferedReader(new InputStreamReader(streamInput));
    }


    public void waitForInput() {

        while (!tokenAvailable()) {
        }
    }


    public boolean tokenAvailable() {

        if (input.size() <= 0) {
            try {
                readInput();
            } catch (final IOException e) {
                return false;
            }
        }
        return input.size() > 0;
    }


    public String nextToken() {

        if (!tokenAvailable()) {
            return "";
        }
        return input.remove(0);
    }


    private void readInput() throws IOException {

        if (!inputStream.ready()) {
            threadSleepToManageCpeThrottling();
            return;
        }

        final String line = inputStream.readLine();

        final List<String> list = new ArrayList<String>();
        list.addAll(Arrays.asList(line.split("\\s+")));
        while (list.size() > 0) {
            final String str = list.remove(0);
            if (str.length() > 0) {
                input.add(str);
            }
        }
        if (input.size() <= 0) {
            throw new IOException("No input read");
        }
    }


    private void threadSleepToManageCpeThrottling() {

        try {
            Thread.sleep(200);
        } catch (final InterruptedException e) {
            // Do nothing
        }
    }
}
