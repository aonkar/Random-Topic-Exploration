package com.example.demo5;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class MaxRightArray {

    public static void main(String[] args) {

        Arrays.stream(nearestRight(new int[]{4,1,3,0,0,1,2})).forEach(System.out::println);
    }

    public static int[] nearestRight(int[] input) {
        final Deque<Integer> maxRightStack = new ArrayDeque<>();
        final int[] output = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            if (maxRightStack.isEmpty()) {
                output[i] = -1;
            } else {
                boolean notFound = true;
                while (notFound) {
                    if (maxRightStack.peek() < input[i]) {
                        output[i] = maxRightStack.peek();
                        notFound = false;
                    } else {
                        maxRightStack.pop();
                        if (maxRightStack.isEmpty()) {
                            output[i] = -1;
                            notFound = false;
                        }
                    }
                }
            }
            maxRightStack.push(input[i]);
        }
        return output;
    }

}
