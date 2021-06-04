package com.example.demo5;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {

    public static void main(String[] args) {
        System.out.println(removeKdigits("10200", 1));
    }

    public static String removeKdigits(String num, int k) {
        final Deque<Integer> stack = new ArrayDeque<>();
        final StringBuilder output = new StringBuilder();
        boolean deleteMore = true;
        for(int i = 0; i < num.length(); i++){
            final int currNumber = num.charAt(i) - '0';
            if(deleteMore){
                if(stack.isEmpty()){
                    stack.push(currNumber);
                }
                else if(stack.peek() < currNumber){
                    k--;
                } else{
                    k--;
                    stack.pop();
                    if(currNumber != 0 || (!stack.isEmpty() && currNumber == 0)){
                        stack.push(currNumber);
                    }
                }
            } else{
                stack.push(currNumber);
            }
            if(k == 0){
                deleteMore = false;
            }
        }
        while (!stack.isEmpty()){
            output.append(stack.pop() + "");
        }
        return output.reverse().toString();
    }
}
