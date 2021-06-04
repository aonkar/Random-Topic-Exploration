package com.example.demo5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class SunsetView {

    public static void main(String[] args) {
        sunsetViews(new int[]{3}, "EAST");
    }

    public static ArrayList<Integer> sunsetViews(int[] c,
                                                 String direction) {
        if(c.length == 0){
            return new ArrayList<>();
        }
        final Deque<Integer> stack = new ArrayDeque<>();
        final ArrayList<Integer> output = new ArrayList<>();
        if (direction.equals("EAST")) {
            for (int i = 0; i < c.length; i++) {
                if (stack.isEmpty() || (c[i] < c[stack.peek()] && i != c.length - 1)) {
                    stack.push(i);
                } else if (c[i] >= c[stack.peek()]) {
                    while (!stack.isEmpty() && c[stack.peek()] <= c[i]) {
                        stack.pop();
                    }
                    if (i != c.length - 1) {
                        stack.push(i);
                    }
                }
            }
            stack.push(c.length - 1);
        } else {
            for (int i = c.length - 1; i >= 0; i--) {
                if (stack.isEmpty() || c[i] < c[stack.peek()] && i != 0) {
                    stack.push(i);
                } else if (c[i] >= c[stack.peek()]) {
                    while (!stack.isEmpty() && c[stack.peek()] <= c[i]) {
                        stack.pop();
                    }
                    if (i != 0) {
                        stack.push(i);
                    }
                }
            }
            stack.push(0);
        }
        while (!stack.isEmpty()) {
            if (direction.equals("EAST")) {
                output.add(stack.pop());
            } else {
                output.add(stack.remove());
            }
        }
         Collections.sort(output);
        return output;
    }
}
