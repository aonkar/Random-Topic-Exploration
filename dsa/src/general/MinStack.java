package com.example.demo5;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack{
    final Deque<Integer> minStack = new ArrayDeque<>();
    final Deque<Integer> tempStack = new ArrayDeque<>();
    public MinStack(final int[] input){
        for(int i = 0; i < input.length; i++){
            if(tempStack.isEmpty() || input[i] < tempStack.peek()){
                tempStack.push(input[i]);
            }
            minStack.push(input[i]);
        }
    }

    public int pop(){
        if(minStack.isEmpty()){
            return -1;
        }
        final int top = minStack.pop();
        if(top < tempStack.peek()){
            tempStack.pop();
        }
        return top;
    }

    public void push(final int input){
        if(tempStack.isEmpty() || input < tempStack.peek()){
            tempStack.push(input);
        }
        minStack.push(input);
    }
    public int minElement(){
        if(tempStack.isEmpty()){
            return -1;
        }
        return tempStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack(new int[]{3,2,4,5,3,8,9,7});
        System.out.println(minStack.pop());
        System.out.println(minStack.minElement());
        System.out.println(minStack.pop());
        System.out.println(minStack.minElement());
        System.out.println(minStack.pop());
        System.out.println(minStack.minElement());
        System.out.println(minStack.pop());
        System.out.println(minStack.minElement());
        System.out.println(minStack.pop());
        System.out.println(minStack.minElement());
        System.out.println(minStack.pop());
        System.out.println(minStack.minElement());
        System.out.println(minStack.pop());
        System.out.println(minStack.minElement());
        System.out.println(minStack.pop());
        System.out.println(minStack.minElement());
        System.out.println(minStack.pop());
        System.out.println(minStack.minElement());
        System.out.println(minStack.pop());
        System.out.println(minStack.minElement());
    }
}
