package com.example.demo5;

public class PrintBooleanExpressionUsingRecurrsion {

    public static void main(String[] args) {
        String input = "!(&(!(&(f)),&(t),|(f,f,t)))";
        input = input.replace(",", "");
        System.out.println(parseBoolExpr(input, '.', 0, input.length() - 1));
    }

    public static boolean parseBoolExpr(String expression,
                                        char operator,
                                        int low,
                                        int high) {
        if (low == high && (operator == '!')) {
            return expression.charAt(0) == 't' ? false : true;
        } else if(low == high && (operator == '&')){
            return false;
        } else if(low == high && (operator == '|')){
            return expression.charAt(0) == 't' ? true : false;
        }
        if (expression.charAt(low) == '!' || expression.charAt(low) == '&' || expression.charAt(low) == '|') {
            final char currOperator = expression.charAt(low);
            low += 2;
            int currLow = low;
            int openCounts = 1;
            while (openCounts != 0) {
                if(expression.charAt(low) == '('){
                    openCounts++;
                } else if(expression.charAt(low) == ')'){
                    openCounts--;
                }
                low++;
            }
            return parseBoolExpr(expression, currOperator, currLow, low-2);

        }
        char firstElement = expression.charAt(low);
        for (int i = low + 1; i <= high; i++) {
            if (operator == '&') {
                if (firstElement == 't' && expression.charAt(i) == 't') {
                    firstElement = 't';
                } else {
                    firstElement = 'f';
                }
            }
            if (operator == '|') {
                if (firstElement == 't' || expression.charAt(i) == 't') {
                    firstElement = 't';
                } else {
                    firstElement = 'f';
                }
            }
        }
        return firstElement == 't' ? true : false;
    }
}
