package com.example.demo5;

import java.util.HashMap;
import java.util.Map;

public class FibonacciSerires {

    public static void main(String[] args) {
        final HashMap<Integer, Integer> output = new HashMap<>();
        output.put(0,0);
        output.put(1,1);
                getFibonacci(6, output);

//        fibonacci(6);
    }

    private static int getFibonacci(final int i,
                                    Map<Integer, Integer> cache) {
        if (cache.containsKey(i)) {
            return cache.get(i);
        }
        if (i == 0) {

            return 0;
        }
        if (i == 1) {
            System.out.println(1);
            return 1;
        }

        int currSum = getFibonacci(i - 1, cache) + getFibonacci(i - 2, cache);
        System.out.println(currSum);
        cache.put(i, currSum);
        return currSum;
    }


    private static void fibonacci(final int i) {
        int prevPrev = 0;
        int prev = 1;
        for(int j = 1; j <= i; j++){
            if (j == 1) {
                System.out.println(0);
            } else if (j == 2) {
                System.out.println(1);
            }
            int curr = prev + prevPrev;
            prevPrev = prev;
            prev = curr;
            System.out.println(curr);
        }
    }
}

//0 1 1 2 3