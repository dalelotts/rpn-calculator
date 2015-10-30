package com.dalelotts.rpn;

import com.dalelotts.rpn.token.OperandToken;
import com.dalelotts.rpn.token.operator.OperatorToken;
import com.dalelotts.rpn.token.CalculatorToken;

import java.io.PrintStream;
import java.util.Stack;


public class RPNCalculator {

    private final PrintStream out;
    private final Stack<CalculatorToken> stack = new Stack<CalculatorToken>();


    public static void main(final String[] args) throws Exception {

        final RPNCalculator calc = new RPNCalculator();
        calc.println("Enter values followed by operation symbols: ");
        calc.run(new StreamTokenizer(System.in));
    }


    /**
     * Default constructor uses System.out for output
     */
    public RPNCalculator() {

        this.out = System.out;
    }


    public RPNCalculator(final PrintStream output) {

        this.out = output;
    }


    public void println(final String string) {
        out.println(string);
    }


    public void run(final StreamTokenizer streamTokenizer) {

        while (true) {
            processInput(streamTokenizer);
        }
    }


    public void processInput(final StreamTokenizer streamTokenizer) {

        streamTokenizer.waitForInput();

        while (streamTokenizer.tokenAvailable()) {

            stack.push(createToken(streamTokenizer.nextToken()));

            if (stack.peek().isOperator()) {
                out.println(stack);
                final OperatorToken operator = (OperatorToken) stack.pop();
                try {
                    operator.execute(stack);
                } catch (final IllegalArgumentException ex) {
                    out.println(ex.getMessage());
                }
            }
            out.println(stack);
        }
    }


    private CalculatorToken createToken(final String symbol) {

        if (OperatorToken.isValidOperatorSymbol(symbol)) {
            return OperatorToken.createOperatorToken(symbol);
        }
        return new OperandToken(symbol);
    }

}
