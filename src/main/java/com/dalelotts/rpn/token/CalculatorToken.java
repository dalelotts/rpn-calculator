package com.dalelotts.rpn.token;

public abstract class CalculatorToken {

    private final String symbol;


    protected CalculatorToken(String symbol) {

        this.symbol = symbol;
    }

    @Override
    public int hashCode() {

        final int prime  = 31;
        int       result = 1;
        result = prime * result + ((getSymbol() == null) ? 0 : getSymbol().hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CalculatorToken other = (CalculatorToken) obj;
        if (getSymbol() == null) {
            if (other.getSymbol() != null) {
                return false;
            }
        } else if (!getSymbol().equals(other.getSymbol())) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {

        return getSymbol();
    }


    public abstract boolean isOperator();


    public String getSymbol() {

        return symbol;
    }

}
