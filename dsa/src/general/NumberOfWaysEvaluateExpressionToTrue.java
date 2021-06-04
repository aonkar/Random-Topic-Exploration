package com.example.demo5;

import java.util.HashMap;
import java.util.Map;

public class NumberOfWaysEvaluateExpressionToTrue {

    public static void main(String[] args) {
        String input = "F|T^F";
//        (T) | (F)&(T^F)
//        (T) | (F&T)^(F)
//        (T) | (F&T^F)
//        (T|F)&(T^F)
//        (T|F&T)^(F)

//         T | F & T^F
//         T | F&T ^ F
//         T|F & T^F
//        T|F&T ^ F

        int output = evaluateExpression(input, 0, input.length() - 1, '.', new HashMap<>());
        System.out.println(output);
    }

    private static int evaluateExpression(final String expression,
                                          int low,
                                          int high,
                                          char operator,
                                          Map<String, Integer> cache) {
        if (low == high) {
            return 'T' == expression.charAt(low) ? 1 : 0;
        }
        int maxCount = 0;
        for (int k = low + 1; k < high; k = k + 2) {
            final int left = evaluateExpression(expression, low, k - 1, expression.charAt(k), cache);
            final int right = evaluateExpression(expression, k + 1, high, expression.charAt(k), cache);
            final int test = getCount(left, right, expression.charAt(k));
            maxCount += test;
        }
        return maxCount;
    }

    private static int getCount(final int left,
                                final int right,
                                final char charAt) {
        if (charAt == '&') {
            return Math.min(left, right);
        } else if (charAt == '^') {
            return Math.abs(right - left);
        } else {
            return left + right;
        }
    }
}
