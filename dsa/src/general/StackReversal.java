package com.example.demo5;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackReversal {

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverseStack(stack);
    }

    private static void reverseStack(final Deque<Integer> stack) {
        if(stack.isEmpty()){
            return;
        }
        int currentElement = stack.pop();
        reverseStack(stack);
        System.out.println(currentElement);
    }
}
